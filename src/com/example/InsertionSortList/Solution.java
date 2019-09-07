package com.example.InsertionSortList;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(1);
        ListNode cur = head, next = null;

        while (cur != null) {
            next = cur.next;
            ListNode p = result;


            while (p.next != null && p.next.val < cur.val) {
                p = p.next;
            }

            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        return result.next;
    }
}
