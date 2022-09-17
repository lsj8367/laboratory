package com.github.lsj8367;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MemoryLeakTest {


//    @Test
//    void test() {
//        Leak leak = new Leak();
//        for (int i = 0; i < 90000000; i++) {
//            leak.addList(i);
//            leak.removeStr(i);
//        }
//    }
//
//    @Test
//    void a() {
//        String a = "a";
//        String b = a;
//        b = null;
//        System.out.println(a);
//    }


    private static class Leak {

        List<String> list = new ArrayList<>();

        private void addList(int a) {
            list.add("testetsetsetset" + a);
        }

        private void removeStr(int i) {
            Object obj = list.get(i);
            obj = null;
        }
    }
}
