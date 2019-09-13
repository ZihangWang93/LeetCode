package com.example.LRUCache;
import java.util.*;
public class Solution {
    private int size;
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head, tail;

    public class Node {
        int key;
        int value;
        Node pre;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Solution(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            delete(temp);
            add(temp);
            return temp.value;
        }
        else return -1;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            delete(temp);
            map.remove(key);
        }
        else if (size == capacity) {
            map.remove(tail.pre.key);
            delete(tail.pre);
        }
        else {
            size += 1;
        }
        Node node = new Node(key, value);
        add(node);
        map.put(key, node);
    }

    private void delete(Node del) {
        del.pre.next = del.next;
        del.next.pre = del.pre;
        del.next = null;
        del.pre = null;
    }

    private void add(Node node) {
        node.next = head.next;
        node.next.pre = node;
        head.next = node;
        node.pre = head;
    }
}
