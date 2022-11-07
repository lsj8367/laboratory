package com.github.lsj8367.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest2 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.github.lsj8367.item39.SampleTest2");

        int tests = 0;
        int passed = 0;

        for (Method m : clazz.getDeclaredMethods()) {

            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.println("테스트 실패 : 예외를 던지지 않음" + m);
                } catch (InvocationTargetException e) {
                    final Throwable cause = e.getCause();
                    final Class<? extends Throwable> classType = m.getAnnotation(ExceptionTest.class).value();

                    if (classType.isInstance(cause)) {
                        passed++;
                    } else {
                        System.out.println("테스트 실패: 기대한예외 = " + classType + " 실제 예외 " + cause);
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.printf("성공 : %d 실패 : %d%n", passed, tests - passed);
    }

}
