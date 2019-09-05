package com.example.AddTwoNumbers;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        int sum = l1.val + l2.val;

        ListNode result = new ListNode(sum % 10);
        int ind  = sum / 10;

        ListNode nodeOne = l1.next;
        ListNode nodeTwo = l2.next;
        ListNode temp = result;
        while (nodeOne != null || nodeTwo != null) {
            if (nodeOne != null && nodeTwo != null) {
                sum = nodeOne.val + nodeTwo.val + ind;
                temp.next = new ListNode(sum % 10);
                ind = sum / 10;
                temp = temp.next;
                nodeOne = nodeOne.next;
                nodeTwo = nodeTwo.next;
            }
            else if (nodeOne != null) {
                sum = nodeOne.val + ind;
                temp.next = new ListNode(sum % 10);
                ind = sum / 10;
                temp = temp.next;
                nodeOne = nodeOne.next;
            }
            else {
                sum = nodeTwo.val + ind;
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
                ind = sum / 10;
                nodeTwo = nodeTwo.next;
            }

        }

        if (ind == 1) {
            temp.next = new ListNode(1);
        }
        return result;
    }
}
