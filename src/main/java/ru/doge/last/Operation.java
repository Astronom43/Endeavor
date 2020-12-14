package ru.doge.last;

public class Operation {

    public ListNode removeFromTail(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, null);
        dummyHead.setNext(head);
        ListNode last = dummyHead;
        ListNode previous = dummyHead;

        for (int i = 1; i <= n + 1; i++) {
            last = last.getNext();
        }

        while (last != null) {
            previous = previous.getNext();
            last = last.getNext();
        }

        previous.setNext(previous.getNext().getNext());
        return dummyHead.getNext();
    }
}
