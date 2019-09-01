package com.example.CopyListWithRandomPointer;

public class SolutionThree {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val, null, null);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        cur = head;
        while (cur != null) {
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }

        cur = head;
        Node copyhead = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            cur.next.next = cur.next.next == null ? null : next.next;
            cur.next = next;
            cur = next;
        }

        return copyhead;
    }

}
