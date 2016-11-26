package com.aldo.experiments.lists;

public class ListReorder {
    public void reorder(ListNode n) {
        int count = count(n);
        int halfWay = count / 2 + count % 2;
        ListNode left = n;
        ListNode right = null;

        int steps = 1;
        while (n!=null){
            ListNode next = n.getNext();

            if(steps==halfWay){
                n.setNext(null);
            }
            if(steps>halfWay){
                n.setNext(right);
                right=n;
            }

            n=next;
            ++steps;
        }

        while (right!=null){
            ListNode nl = left.getNext();
            ListNode nr = right.getNext();
            left.setNext(right);
            right.setNext(nl);
            left = nl;
            right = nr;
        }
    }

    int count(ListNode n) {
        int count = 0;
        while (n!=null) {
            ++count;
            n = n.getNext();
        }
        return count;
    }
}
