package com.github.lsj8367;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;

public class MaybeCreateExample {
    public static void main(String[] args) {
        final Maybe<String> maybe = Maybe.create(MaybeEmitter::onComplete);

        maybe.subscribe(new MaybeObserver<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("on subscribe");
            }

            @Override
            public void onSuccess(@NonNull String s) {
                System.out.println("on success");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("on error");
            }

            @Override
            public void onComplete() {
                System.out.println("on complete");
            }
        });


    }
}
