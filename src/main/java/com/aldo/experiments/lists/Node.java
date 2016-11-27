package com.aldo.experiments.lists;

import java.util.function.Consumer;

public class Node<T> {
    public Node next;
    public final T val;

    public Node(T val, Node next) {
        this(val);
        this.next = next;
    }

    public Node(T val) {
        this.val = val;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void apply(Consumer<Node> action) {
        action.accept(this);
    }

    public String toString() {

        return String.valueOf(val);
    }
}
