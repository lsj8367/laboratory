package com.github.lsj8367;

import io.reactivex.rxjava3.core.Maybe;

import java.time.LocalDateTime;

public class MaybeJustExample {
    public static void main(String[] args) {
        Maybe.just(LocalDateTime.now())
                .subscribe(
                        data -> System.out.println("현재시각 : " + data),
                        error -> System.out.println("error!!!" + error),
                        () -> System.out.println("complete!")
                );
    }
}
