package com.github.lsj8367.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class WrongStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public WrongStack(final Object[] elements) {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[++size] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        // 메모리 누수는 여기서 일어난다.
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
