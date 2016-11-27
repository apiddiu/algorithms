package com.aldo.experiments.lists;

public class ListReorder {
    public void reorder(Node n) {
        int count = count(n);
        int halfWay = count / 2 + count % 2;
        Node left = n;
        Node right = null;

        int steps = 1;
        while (n!=null){
            Node next = n.next;

            if(steps==halfWay){
                n.next=null;
            }
            if(steps>halfWay){
                n.next=right;
                right=n;
            }

            n=next;
            ++steps;
        }

        while (right!=null){
            Node nl = left.next;
            Node nr = right.next;
            left.next=right;
            right.next=nl;
            left = nl;
            right = nr;
        }
    }

    int count(Node n) {
        int count = 0;
        while (n!=null) {
            ++count;
            n = n.next;
        }
        return count;
    }
}
