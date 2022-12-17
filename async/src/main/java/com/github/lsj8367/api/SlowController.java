package com.github.lsj8367.api;

import com.github.lsj8367.application.SlowService;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record SlowController(SlowService slowService) {

    @GetMapping("/sync/slow-test")
    public ResponseEntity<Integer> executeSync() throws InterruptedException{
        final int first = slowService.first();

        //순서 보장은 필요 없지만 first()의 메소드 자원은 공유하는 경우
        final int value1 = slowService.call2(first);
        final int value2 = slowService.call3(first);
        final int value3 = slowService.call4(first);

        int sum = value1 + value2 + value3;
        return ResponseEntity.ok(sum);
    }

    @GetMapping("/async/slow-test")
    public ResponseEntity<Integer> executeAsync() throws ExecutionException, InterruptedException {
        final int first = slowService.first();
        ExecutorService service = Executors.newFixedThreadPool(3);

        //비동기로 먼저 열어두고 병렬처리 후 동기로 묶어준다.
        // 가장 느린 데이터 반환의 시간에 맞춰진다.
        // 동시에 실행하기 때문에 가장 느린애의 시간이 곧 작업완료시간과 동일해진다.
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(
            () -> {
                try {
                    return slowService.call2(first);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, service
        );
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(
            () -> {
                try {
                    return slowService.call3(first);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, service
        );

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(
            () -> {
                try {
                    return slowService.call4(first);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, service
        );

        final List<CompletableFuture<Integer>> futureList = List.of(future1, future2, future3);

        int sum = 0;
        final CompletableFuture<List<Integer>> result = CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]))
            .thenApply(v -> futureList.stream()
                    .map(CompletableFuture::join)
                    .toList());

        for (Integer integer : result.get()) {
            sum += integer;
        }

        return ResponseEntity.ok(sum);
    }
}
