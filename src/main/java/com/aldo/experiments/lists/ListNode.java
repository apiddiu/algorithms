package com.aldo.experiments.lists;

import java.util.function.Consumer;

public class ListNode<T> {
    private ListNode next;
    private T val;

    public ListNode(T val, ListNode next) {
        this(val);
        this.next = next;
    }

    public ListNode(T val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {

        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T getVal() {
        return val;
    }

    public void apply(Consumer<ListNode> action) {
        action.accept(this);
    }

    public String toString() {

        return String.valueOf(val);
    }
}
