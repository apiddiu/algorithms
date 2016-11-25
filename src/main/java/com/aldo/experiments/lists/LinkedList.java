package com.aldo.experiments.lists;

public class LinkedList {

    public int count = 0;

    public ListNode revertIterative(ListNode current) {
        ListNode previous = null;
        ListNode next;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            next.setNext(current);
            previous = current;
            current = next;
        }

        return current;
    }

    public ListNode revertRecursive(ListNode prev, ListNode curr) {
        ListNode head = curr;

        if (curr.hasNext()) {
            ListNode next = curr.getNext();
            head = revertRecursive(curr, next);
            next.setNext(curr);
        }

        curr.setNext(prev);
        return head;
    }


    public ListNode segregateEvenOdd(ListNode head) {
        ListNode odd = null;
        ListNode oddTale = null;
        ListNode even = null;
        ListNode evenTale = null;
        ListNode current = head;

        while (current!=null) {
            if(even(current)){
                if(even==null) {even=current; evenTale=current;}
                else {evenTale.setNext(current); evenTale=current;}
            }
            else{
                if(odd==null) {odd=current; oddTale=current;}
                else {oddTale.setNext(current); oddTale=current;}
            }
            current=current.getNext();
            ++count;
        }

        if(oddTale!=null){
            oddTale.setNext(null);
        }

        if(even!=null){
            evenTale.setNext(odd);
            return even;
        }
        else{
            return odd;
        }
    }

    private void swap(ListNode prev, ListNode current, ListNode nextEven, ListNode lastOdd) {
        if (nextEven != null) {
            if (prev != null) {
                prev.setNext(nextEven);
            }
            lastOdd.setNext(nextEven.getNext());
            nextEven.setNext(current);
            ++count;
        }
    }

    private boolean even(ListNode n) {
        return ((int) n.getVal()) % 2 == 0;
    }

    private boolean odd(ListNode n) {
        return !even(n);
    }

    private Next next(ListNode n) {
        ListNode even = null;
        ListNode odd = n;
        while (n.hasNext() && even == null) {
            count++;
            n = n.getNext();
            if (even(n)) {
                even = n;
            }
            if (odd(n)) {
                odd = n;
            }
        }
        return new Next(even, odd);
    }

    private ListNode nextEven(ListNode n) {
        while (n.hasNext()) {
            n = n.getNext();
            ++count;
            if (even(n)) {
                return n;
            }
        }

        return null;
    }

    private ListNode nextOdd(ListNode n) {
        while (n != null) {
            if (odd(n)) {
                return n;
            }
            ++count;
            n = n.getNext();
        }

        return null;
    }
    //
    //        private ListNode lastOdd(ListNode n) {
    //            while (n.hasNext()) {
    //
    //                ListNode next = n.getNext();
    //                if (even(next)) {
    //                    return n;
    //                }
    //                n = next;
    //                ++count;
    //            }
    //
    //            return null;
    //        }

    public void print(ListNode n) {
        while (n != null) {
            n.apply(System.out::print);
            if (n.hasNext()) {
                System.out.print(",");
            }
            n = n.getNext();
        }
    }

    class Next {
        public ListNode odd;
        public ListNode even;

        public Next(ListNode even, ListNode odd) {
            this.even = even;
            this.odd = odd;
        }
    }

    class Range {
        public ListNode init;
        public ListNode end;

        public Range(ListNode init, ListNode end) {
            this.end = init;
            this.init = end;
        }
    }
}
