package com.aldo.experiments.lists;

public class ListReorderOthers {
    Node reorderlist(Node head)
    {
        if(head==null)//if zero nodes
            return null;
        if(head.next==null)//if only one node
            return head;
        Node secondHalf=divideListInTwoHalf(head);
        secondHalf=reverseList(secondHalf);

        Node temp1,temp2;
        temp1=head;temp2=secondHalf;
        Node n=null;
        while(temp1!=null && temp2!=null){
            n=temp2;
            temp2=temp2.next;
            n.next=temp1.next;
            temp1.next=n;
            temp1=temp1.next.next;
        }
        if(temp2!=null){
            n.next=temp2;
        }
        return head;
    }

    public static Node reverseList(Node head){
        if(head==null)
            return null;
        Node pre,current,next;
        pre=null;current=head;next=null;

        while(current!=null){
            next=current.next;
            current.next=pre;
            pre=current;
            current=next;
        }
        return pre;
    }

    public static Node divideListInTwoHalf(Node head){
        if(head==null){
            return null;
        }
        Node slow,fast,pre;
        slow=head;fast=head;pre=null;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            pre=slow;
            slow=slow.next;
        }
        if(fast.next!=null){
            pre=slow;
            slow=slow.next;
        }
        pre.next=null;
        return slow;
    }
}
