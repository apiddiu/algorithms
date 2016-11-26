package com.aldo.experiments.lists;

import org.junit.Assert;
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

    private void testReorder(Integer[] expectedItems) {
        ListNode<Integer> list = buildList(expectedItems.length);
        lr.reorder(list);
        checkItemsSequence(expectedItems, list);
    }

    private <T> void checkItemsSequence(T[] expectedItems, ListNode<T> list) {
        int count = 0;

        while (list != null) {
            assertEquals(expectedItems[count], list.getVal());
            ++count;
            System.out.print(list);
            if (list.hasNext()) System.out.print("->");
            list = list.getNext();

        }
        System.out.println();
    }

    private ListNode<Integer> buildList(int itemsCount) {
        ListNode<Integer> head = null;

        for (int i = itemsCount; i > 0; i--) {
            head = new ListNode(i, head);
        }

        return head;
    }

}
