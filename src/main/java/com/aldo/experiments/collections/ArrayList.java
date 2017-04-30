package com.aldo.experiments.collections;

import static java.lang.System.arraycopy;

public class ArrayList<T> {
    private Object[] array = new Object[10];
    private int index = 0;

    public void add(T t) {
        if (array[index] != null)
            index++;

        if (index >= array.length - 1)
            grow();

        array[index++] = t;
    }

    public void insert(T t, int index) {
        if (array[index] != null)
            moveRight(index);

        array[index] = t;
    }


    public T get(int index) {
        return (T) array[index];
    }

    public T removeAt(int index) {
        T t = get(index);

        moveLeft(index);

        return t;
    }

    private void moveLeft(int index) {
        arraycopy(array, index + 1, array, index, array.length - index - 1);
    }

    private void moveRight(int index) {
        arraycopy(array, index, array, index + 1, array.length - index - 1);
    }

    private void grow() {
        Object[] newarray = new Object[2 * array.length];
        arraycopy(array, 0, newarray, 0, array.length);
        array = newarray;
    }
}
