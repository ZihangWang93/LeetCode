package com.example.ReverseLinkedList;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode cur = temp;
            temp = temp.next;
            cur.next = prev;
            prev = cur;
        }
        return prev;
    }
}
