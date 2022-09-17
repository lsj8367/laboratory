package com.github.lsj8367.item7;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {

//    public static void main(String[] args) {
//        String ss = "문자열";
//        SoftReference<String> reference = new SoftReference<>(ss);
//
//        // 이 시점에 GC의 실행 대상이 가능
//        ss = null;
//
//        System.gc();
//
//        // JVM의 메모리가 부족하지 않아서 GC 실행 대상이 되지 않은 경우
//        // 그대로 유지한다.
//        ss = reference.get();
//        System.out.println(ss);
//    }

//    public static void main(String[] args) {
//        String ss = "문자열";
//        WeakReference<String> reference = new WeakReference<>(ss);
//
//         이 시점에 GC의 실행 대상이 가능
//        ss = null;
//
//        System.gc();

        // gc를 명시적으로 호출했지만 컬렉션이 동작하지 않을수도 있음
        // 그래도 무조건 동작한다고 가정
//        ss = reference.get();

        // null 로 비어있게 된다.
//        System.out.println(ss);
//    }
}
