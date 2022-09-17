package com.github.lsj8367.item9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryException {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new ExceptionReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } finally {
            br.close();
        }
    }
}
