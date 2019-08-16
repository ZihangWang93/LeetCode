package com.example.BinaryTreeMaximumPathSum;

public class SolutionTwo {
    private int result = Integer.MIN_VALUE;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root) {
        int temp = dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));
        result = Math.max(result, node.val + left + right);
        return Math.max(node.val + left, node.val + right);
    }
}
