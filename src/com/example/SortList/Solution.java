package com.example.SortList;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {val = x;}
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = head;
        ListNode end = head;
        ListNode prev = null;

        while (end != null && end.next != null) {
            prev = mid;
            mid = mid.next;
            end = end.next.next;
        }
        prev.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode result = new ListNode(0);
        ListNode temp = result;

        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            }
            else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left == null) {
            temp.next = right;
        }
        if (right == null) {
            temp.next = left;
        }
        return result.next;
    }
}
