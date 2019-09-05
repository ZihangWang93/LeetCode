package com.example.AddTwoNumbers;

public class SolutionTwo {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode res = new ListNode(-1), tail = res;
        int sum = 0;
        while (l1 != null || l2 != null || sum >= 10) {
            sum = sum / 10;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

        }

        return res.next;
    }
}
