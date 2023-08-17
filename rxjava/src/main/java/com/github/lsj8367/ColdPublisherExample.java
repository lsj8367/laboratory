package com.github.lsj8367;

import io.reactivex.rxjava3.core.Flowable;

public class ColdPublisherExample {
    public static void main(String[] args) {
        Flowable<Integer> flowable = Flowable.just(1, 2, 3, 4);
        flowable.subscribe(data -> System.out.println("subscriber1 : " + data));
        flowable.subscribe(data -> System.out.println("subscriber2 : " + data));
    }
}
