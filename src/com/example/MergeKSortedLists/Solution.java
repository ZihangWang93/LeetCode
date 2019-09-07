package com.example.MergeKSortedLists;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if (n == 0) return null;
        if (n == 1) return lists[0];

        return merge(lists, 0, n - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start == end - 1) {
            return mergeTwo(lists[start], lists[end]);
        }
        else {
            ListNode left = merge(lists, start, (start + end) / 2);
            ListNode right = merge(lists, (start + end) / 2 + 1, end);
            return mergeTwo(left, right);
        }
    }

    private ListNode mergeTwo(ListNode left, ListNode right) {
        ListNode pointOne = left;
        ListNode pointTwo = right;
        ListNode result = new ListNode(0);
        ListNode temp = result;

        while (pointOne != null && pointTwo != null) {
            if (pointOne.val < pointTwo.val) {
                temp.next = new ListNode(pointOne.val);
                pointOne = pointOne.next;
            }
            else {
                temp.next = new ListNode(pointTwo.val);
                pointTwo = pointTwo.next;
            }
            temp = temp.next;
        }

        if (pointOne != null) {
            temp.next = pointOne;
        }
        if (pointTwo != null) {
            temp.next = pointTwo;
        }

        return result.next;
    }
}
