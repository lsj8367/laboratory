package com.github.lsj8367.item2.exception;

import java.io.IOException;

public class ExceptionExample {

    private void nullPointerException() throws NullPointerException {
        System.out.println();
    }

    private void illegalArgumentException() throws IllegalArgumentException {
        System.out.println();
    }

    private void runtimeException() throws RuntimeException {
        System.out.println();
    }

    private void ioException() throws IOException {
        System.out.println();
    }

//    public static void main(String[] args) {
//        ExceptionExample example = new ExceptionExample();
//        try {
//            example.ioException();
//        } catch (IOException e) {
//
//        }
//        example.runtimeException();
//        example.illegalArgumentException();
//        example.nullPointerException();
//
//    }
}
