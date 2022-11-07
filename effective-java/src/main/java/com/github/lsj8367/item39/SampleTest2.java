package com.github.lsj8367.item39;

public class SampleTest2 {

    @ExceptionTest(RuntimeException.class)
    public static void test1() {
        throw new RuntimeException("예외처리 성공");
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {
        int[] arr = new int[1];
        System.out.println(arr[3]);
    }
}
