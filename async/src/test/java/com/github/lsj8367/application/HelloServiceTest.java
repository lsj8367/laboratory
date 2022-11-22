package com.github.lsj8367.application;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

    @Test
    void test() {
        Thread thread = new MyThread();
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }

    private class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("thread");
        }

    }

}
