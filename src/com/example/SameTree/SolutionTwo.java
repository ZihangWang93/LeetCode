package com.example.SameTree;

import java.util.*;

public class SolutionTwo {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> next = new LinkedList<>();
        next.offer(p);
        next.offer(q);

        while (!next.isEmpty()) {
            TreeNode n1 = next.poll();
            TreeNode n2 = next.poll();

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;

            next.offer(n1.left);
            next.offer(n2.left);
            next.offer(n1.right);
            next.offer(n2.right);
        }

        return true;
    }
}
