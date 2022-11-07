package com.github.lsj8367.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.github.lsj8367.item39.SampleTest");

        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                tests++;

                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException e) {
                    final Throwable cause = e.getCause();
                    System.out.println(method + "실패" + cause);
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @Test : " + method);
                }
            }
        }
        System.out.printf("성공 : %d 실패 : %d%n", passed, tests - passed);

    }

}
