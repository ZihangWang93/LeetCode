package com.example.CloneGraph;

import java.util.*;

public class Solution {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        if (node.neighbors == null || node.neighbors.size() == 0) {
            return new Node(node.val, new LinkedList<Node>());
        }

        Node[] clone = new Node[101];
        Queue<Node> next = new LinkedList<>();
        clone[node.val] = new Node(node.val, new LinkedList<Node>());

        next.add(node);

        while (!next.isEmpty()) {
            Node temp = next.remove();
            for (Node n : temp.neighbors) {
                if (clone[n.val] == null) {
                    clone[n.val] = new Node(n.val, new LinkedList<Node>());
                    next.add(n);
                }
                clone[temp.val].neighbors.add(clone[n.val]);
            }
        }

        return clone[node.val];
    }
}
