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
        Node head = initList(10);
        ll.print(head);

        ll.revertIterative(head).apply(n -> System.out.println(n));
    }

    private Node initList(int elements) {
        Node head = null;

        while (elements >= 0) {
            head = new Node(elements--, head);
        }

        return head;
    }

    @Test
    public void segregateTest() {
        Node<Integer> n1 = new Node<>(2,
            new Node<>(17,
                new Node<>(4,
                    new Node<>(7,
                        new Node<>(3)))));

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
        Node<Integer> n1 = new Node<>(17,
            new Node<>(7,
                new Node<>(2,
                    new Node<>(4,
                        new Node<>(3)))));

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
        Node<Integer> n1 = new Node<>(2,
            new Node<>(4,
                new Node<>(6,
                    new Node<>(8,
                        new Node<>(10)))));

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
        Node<Integer> n1 = new Node<>(17,
            new Node<>(7,
                new Node<>(3,
                    new Node<>(9,
                        new Node<>(11)))));

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
        Node<Integer> n1 = new Node<>(17,
            new Node<>(7,
                new Node<>(2,
                    new Node<>(4,
                        new Node<>(11)))));

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
        Node<Integer> h = null;
        Set<Integer> s = new HashSet<>();
        Random r = new Random(System.nanoTime());

        while (s.size() < 100) {
            s.add(r.nextInt(200));
        }

        for (Integer i : s) {
            h = new Node<>(i, h);
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
