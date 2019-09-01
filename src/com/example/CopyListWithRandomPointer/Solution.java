package com.example.CopyListWithRandomPointer;
import java.util.*;
public class Solution {

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



        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;

        while (temp != null) {
            map.put(temp, new Node(temp.val, null, null));
            temp = temp.next;
        }

        temp = head;
        Node result = map.get(temp);
        while (temp != null) {
            Node copy = map.get(temp);
            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);
            temp = temp.next;
        }
        return result;
    }
}
