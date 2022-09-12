package com.github.lsj8367.item6;

import org.junit.jupiter.api.Test;

public class BoxingTest {

    @Test
    void 박싱_타입_테스트() {
        sumBox();
    }

    private long sumBox() {
        Long l = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            l += i;
        }
        return l;
    }

    @Test
    void 기본_타입_테스트() {
        sum();
    }

    private long sum() {
        long l = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            l += i;
        }
        return l;
    }

}
