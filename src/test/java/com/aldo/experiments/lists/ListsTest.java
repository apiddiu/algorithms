package com.aldo.experiments.lists;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ListsTest {
    private LinkedList ll = new LinkedList();

    @Test
    @Ignore
    public void testList() {
        ListNode head = initList(10);
        ll.print(head);

        ll.revertIterative(head).apply(n -> System.out.println(n));
    }

    private ListNode initList(int elements) {
        ListNode head = null;

        while (elements >= 0) {
            head = new ListNode(elements--, head);
        }

        return head;
    }

    @Test
    public void segregateTest() {
        ListNode<Integer> n1 = new ListNode<>(2,
            new ListNode<>(17,
                new ListNode<>(4,
                    new ListNode<>(7,
                        new ListNode<>(3)))));

        ll.print(n1);
        System.out.println();
        System.out.println("---------------------------------");
        ll.print(ll.segregateEvenOdd(n1));
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Count: " + ll.count);
    }

    @Test
    public void segregateTest1() {
        ListNode<Integer> n1 = new ListNode<>(17,
            new ListNode<>(7,
                new ListNode<>(2,
                    new ListNode<>(4,
                        new ListNode<>(3)))));

        ll.print(n1);
        System.out.println();
        System.out.println("---------------------------------");
        ll.print(ll.segregateEvenOdd(n1));
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Count: " + ll.count);
    }

    @Test
    public void segregateTest2() {
        ListNode<Integer> n1 = new ListNode<>(2,
            new ListNode<>(4,
                new ListNode<>(6,
                    new ListNode<>(8,
                        new ListNode<>(10)))));

        ll.print(n1);
        System.out.println();
        System.out.println("---------------------------------");
        ll.print(ll.segregateEvenOdd(n1));
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Count: " + ll.count);
    }

    @Test
    public void segregateTest3() {
        ListNode<Integer> n1 = new ListNode<>(17,
            new ListNode<>(7,
                new ListNode<>(3,
                    new ListNode<>(9,
                        new ListNode<>(11)))));

        ll.print(n1);
        System.out.println();
        System.out.println("---------------------------------");
        ll.print(ll.segregateEvenOdd(n1));
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Count: " + ll.count);
    }

    @Test
    public void segregateTest4() {
        ListNode<Integer> n1 = new ListNode<>(17,
            new ListNode<>(7,
                new ListNode<>(2,
                    new ListNode<>(4,
                        new ListNode<>(11)))));

        ll.print(n1);
        System.out.println();
        System.out.println("---------------------------------");
        ll.print(ll.segregateEvenOdd(n1));
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Count: " + ll.count);
    }

    @Test
    public void segregateTestLong() {
        ListNode<Integer> h = null;
        Set<Integer> s = new HashSet<>();
        Random r = new Random(System.nanoTime());

        while (s.size() < 100) {
            s.add(r.nextInt(200));
        }

        for (Integer i : s) {
            h = new ListNode<>(i, h);
        }

        ll.print(h);
        System.out.println();
        System.out.println("---------------------------------");
        ll.print(ll.segregateEvenOdd(h));
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println("Count: " + ll.count);
    }
}
