package com.example.KthSmallestElementInABST;

public class SolutionTwo {
    private int result;
    private int count;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        if (--count == 0) result = node.val;
        dfs(node.right);
    }
}
