package com.github.lsj8367.item79;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());

//        set.addObserver((s, e) -> System.out.println(e));

        // ConcurrentModifiableException
//        set.addObserver(new SetObserver<>() {
//            @Override
//            public void added(final ObservableSet<Integer> integers, final Integer element) {
//                System.out.println(element);
//                if (element == 23) {
//                    integers.removeObserver(this);
//                }
//            }
//        });

        // DeadLock addObserver가 monitor 를 가지고 lock을 쥐고 있는데
        // 정수값이 23이 되면 removeObserver를 호출하는데 여기서 lock 반환이 안되어 계속 기다리게 된다.
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(final ObservableSet<Integer> set, final Integer e) {
                System.out.println(e);
                if (e == 23) {
                    ExecutorService service = Executors.newSingleThreadExecutor();

                    try {
                        service.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException ex) {
                        throw new AssertionError(ex);
                    } finally {
                        service.shutdown();
                    }
                }
            }
        });

        for (int i = 0; i < 100; i++) {
            set.add(i);
        }
    }

}
