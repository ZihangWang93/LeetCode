package com.example.CloneGraph;

import java.util.*;

public class SolutionTwo {

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

        HashMap<Node, Node> map = new HashMap<>();
        return dfs(map, node);
    }

    private Node dfs(HashMap<Node, Node> map, Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        map.put(node, new Node(node.val, new LinkedList<Node>()));

        for (Node n : node.neighbors) {
            map.get(node).neighbors.add(dfs(map, n));
        }
        return map.get(node);
    }
}
