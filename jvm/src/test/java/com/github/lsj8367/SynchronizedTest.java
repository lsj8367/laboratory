package com.github.lsj8367;

import org.junit.jupiter.api.Test;

class SynchronizedTest {

    @Test
    void test() {
        int[] arr = new int[10];

        synchronized (this) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }
    }

    synchronized void add() {
        int[] arr = new int[10];

        synchronized (this) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }
    }

}
