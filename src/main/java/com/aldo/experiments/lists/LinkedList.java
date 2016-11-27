package com.aldo.experiments.lists;

public class LinkedList {

    public int count = 0;

    public Node revertIterative(Node current) {
        Node previous = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            next.next = current;
            previous = current;
            current = next;
        }

        return current;
    }

    public Node revertRecursive(Node prev, Node curr) {
        Node head = curr;

        if (curr.hasNext()) {
            Node next = curr.next;
            head = revertRecursive(curr, next);
            next.next = curr;
        }

        curr.next = prev;
        return head;
    }


    public Node segregateEvenOdd(Node head) {
        Node odd = null;
        Node oddTale = null;
        Node even = null;
        Node evenTale = null;
        Node current = head;

        while (current != null) {
            if (even(current)) {
                if (even == null) {
                    even = current;
                    evenTale = current;
                } else {
                    evenTale.next = current;
                    evenTale = current;
                }
            } else {
                if (odd == null) {
                    odd = current;
                    oddTale = current;
                } else {
                    oddTale.next = current;
                    oddTale = current;
                }
            }
            current = current.next;
            ++count;
        }

        if (oddTale != null) {
            oddTale.next = null;
        }

        if (even != null) {
            evenTale.next = odd;
            return even;
        } else {
            return odd;
        }
    }

    private void swap(Node prev, Node current, Node nextEven, Node lastOdd) {
        if (nextEven != null) {
            if (prev != null) {
                prev.next = nextEven;
            }
            lastOdd.next = nextEven.next;
            nextEven.next = current;
            ++count;
        }
    }

    private boolean even(Node n) {
        return ((int) n.val) % 2 == 0;
    }

    private boolean odd(Node n) {
        return !even(n);
    }

    private Next next(Node n) {
        Node even = null;
        Node odd = n;
        while (n.hasNext() && even == null) {
            count++;
            n = n.next;
            if (even(n)) {
                even = n;
            }
            if (odd(n)) {
                odd = n;
            }
        }
        return new Next(even, odd);
    }

    private Node nextEven(Node n) {
        while (n.hasNext()) {
            n = n.next;
            ++count;
            if (even(n)) {
                return n;
            }
        }

        return null;
    }

    private Node nextOdd(Node n) {
        while (n != null) {
            if (odd(n)) {
                return n;
            }
            ++count;
            n = n.next;
        }

        return null;
    }
    //
    //        private Node lastOdd(Node n) {
    //            while (n.hasNext()) {
    //
    //                Node next = n.next;
    //                if (even(next)) {
    //                    return n;
    //                }
    //                n = next;
    //                ++count;
    //            }
    //
    //            return null;
    //        }

    public void print(Node n) {
        while (n != null) {
            n.apply(System.out::print);
            if (n.hasNext()) {
                System.out.print(",");
            }
            n = n.next;
        }
    }

    class Next {
        public Node odd;
        public Node even;

        public Next(Node even, Node odd) {
            this.even = even;
            this.odd = odd;
        }
    }

    class Range {
        public Node init;
        public Node end;

        public Range(Node init, Node end) {
            this.end = init;
            this.init = end;
        }
    }
}
