package com.example.CopyListWithRandomPointer;

import java.util.*;

public class SolutionTwo {
    HashMap<Node, Node> map = new HashMap<>();

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

        if (map.containsKey(head)) return map.get(head);
        Node node = new Node(head.val, null, null);
        map.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}
