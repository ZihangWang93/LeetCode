package com.example.BinaryTreeInorderTraversal;

import java.util.*;

class SolutionTwo {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new LinkedList<>();
        Stack<TreeNode> next = new Stack<>();

        if (root == null) return result;
        TreeNode cur = root;

        while (cur != null || !next.isEmpty()) {
            while( cur != null) {
                next.push(cur);
                cur = cur.left;

            }
            cur = next.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
