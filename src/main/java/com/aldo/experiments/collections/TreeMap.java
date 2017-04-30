package com.aldo.experiments.collections;

import java.util.function.Consumer;

public class TreeMap<T extends Comparable> {
    private T element;
    private TreeMap<T> left;
    private TreeMap<T> right;

    public TreeMap(T element) {
        this.element = element;
    }

    public void insert(T t) {
        int compare = t.compareTo(element);
        if (compare == 0) return;
        if (compare < 0) insertLeft(t);
        if (compare >= 0) insertRight(t);
    }

    public void sorted(Consumer<T> c){
        if(left!=null) left.sorted(c);
        c.accept(element);
        if(right!=null) right.sorted(c);
    }

    private void insertLeft(T t) {
        if (left == null)
            left = new TreeMap<>(t);
        else left.insert(t);
    }

    private void insertRight(T t) {
        if (right == null)
            right = new TreeMap<>(t);
        else right.insert(t);
    }
}
