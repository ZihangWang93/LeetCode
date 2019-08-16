package com.example.BinaryTreeMaximumPathSum;

public class Solution {
    private int result;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        int temp = dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            if (node.val > result) {
                result = node.val;
            }
            return node.val;
        }

        if (node.left == null) {
            int temp = dfs(node.right);
            int max = Math.max(node.val, node.val + temp);
            if (max > result) {
                result = max;
            }

            if (temp > 0) {
                return node.val + temp;
            }
            return node.val;
        }

        if (node.right == null) {
            int temp = dfs(node.left);
            int max = Math.max(node.val, node.val + temp);
            if (max > result) {
                result = max;
            }

            if (temp > 0) {
                return node.val + temp;
            }
            return node.val;
        }

        int tempLeft = dfs(node.left);
        int tempRight = dfs(node.right);
        int max = Math.max(Math.max(node.val, node.val + tempLeft + tempRight), Math.max(node.val + tempLeft, node.val + tempRight));
        if (max > result) {
            result = max;
        }
        int temp = Math.max(tempLeft, tempRight);
        if (temp > 0) {
            return node.val + temp;
        }
        return node.val;
    }
}
