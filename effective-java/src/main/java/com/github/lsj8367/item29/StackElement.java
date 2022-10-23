package com.github.lsj8367.item29;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackElement<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private Object[] elements;
    private int size = 0;

    public StackElement() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E o) {
        ensureCapacity();
        elements[++size] = o;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        @SuppressWarnings("unchecked") E result = (E) elements[size--];
        elements[size] = null;

        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

}
