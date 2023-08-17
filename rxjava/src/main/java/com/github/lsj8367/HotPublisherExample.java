package com.github.lsj8367;

import io.reactivex.rxjava3.processors.PublishProcessor;

public class HotPublisherExample {
    public static void main(String[] args) {
        PublishProcessor<Integer> processor = PublishProcessor.create();
        processor.subscribe(data -> System.out.println("subscriber 1 : " + data));
        processor.onNext(1);
        processor.onNext(2);

        processor.subscribe(data -> System.out.println("subscriber 2 : " + data));
        processor.onNext(3);
        processor.onNext(4);
    }
}
