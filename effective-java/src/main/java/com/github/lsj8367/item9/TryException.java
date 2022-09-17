package com.github.lsj8367.item9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryException {

    // 이중예외중 한개는 무시되는 일반 try-finally
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new ExceptionReader(new InputStreamReader(System.in));
//        try {
//            br.readLine();
//        } finally {
//            br.close();
//        }
//    }

    // 두 예외가 전부 보여지는 try-with-resources
//    public static void main(String[] args) throws IOException {
//        try(BufferedReader br = new ExceptionReader(new InputStreamReader(System.in))) {
//            br.readLine();
//        }
//    }
}
