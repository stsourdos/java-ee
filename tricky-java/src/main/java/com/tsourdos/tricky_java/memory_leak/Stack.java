package com.tsourdos.tricky_java.memory_leak;

import java.util.Arrays;

/**
 *
 * @author s.tsourdos
 */
public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new RuntimeException();
        }
        // memory leak
        return elements[--size];
    }

    public Object popWithoutMemLeak() {
        if (size == 0) {
            throw new RuntimeException();
        }
        Object obj = elements[--size];
        elements[size] = null; // eliminate obsolete reference
        return obj;
    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity each time the array needs to
     * grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
