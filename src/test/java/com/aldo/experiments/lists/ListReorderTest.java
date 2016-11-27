package com.aldo.experiments.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListReorderTest {
    private ListReorder lr;

    @Before
    public void setUp() throws Exception {
        lr = new ListReorder();
    }

    @Test
    public void reorderSingleItemList() {
        Integer expected[] = new Integer[]{1};
        testReorder(expected);
    }

    @Test
    public void reorderTwoItemsList() {
        Integer expected[] = new Integer[]{1, 2};
        testReorder(expected);
    }

    @Test
    public void reorderEvenList() {
        Integer expected[] = new Integer[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        testReorder(expected);
    }

    @Test
    public void reorderOddList() {
        Integer expected[] = new Integer[]{1, 11, 2, 10, 3, 9, 4, 8, 5, 7, 6};
        testReorder(expected);
    }

    @Test
    public void listReorderLongRun() {
        Node<Integer> list = buildList(100000);
        long fast, slow, tot;
        fast = Long.MAX_VALUE;
        slow = tot = 0;

        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            lr.reorder(list);
            long end = System.currentTimeMillis();

            long time = end - start;

            if (time > slow) slow = time;
            if (time < fast) fast = time;
            tot += time;
        }

        System.out.println("Fast: " + fast);
        System.out.println("Slow: " + slow);
        System.out.println("Avg: " + tot / 100);
    }

    @Test
    public void listReorderLongRunOthers() {
        ListReorderOthers lro = new ListReorderOthers();
        Node<Integer> list = buildList(100000);
        long fast, slow, tot;
        fast = Long.MAX_VALUE;
        slow = tot = 0;

        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            lro.reorderlist(list);
            long end = System.currentTimeMillis();

            long time = end - start;

            if (time > slow) slow = time;
            if (time < fast) fast = time;
            tot += time;
        }

        System.out.println("Fast: " + fast);
        System.out.println("Slow: " + slow);
        System.out.println("Avg: " + tot / 100);
    }

    private void testReorder(Integer[] expectedItems) {
        Node<Integer> list = buildList(expectedItems.length);
        lr.reorder(list);
        checkItemsSequence(expectedItems, list);
    }

    private <T> void checkItemsSequence(T[] expectedItems, Node<T> list) {
        int count = 0;

        while (list != null) {
            assertEquals(expectedItems[count], list.val);
            ++count;
            System.out.print(list);
            if (list.hasNext()) System.out.print("->");
            list = list.next;

        }
        System.out.println();
    }

    private Node<Integer> buildList(int itemsCount) {
        Node<Integer> head = null;

        for (int i = itemsCount; i > 0; i--) {
            head = new Node(i, head);
        }

        return head;
    }

}
