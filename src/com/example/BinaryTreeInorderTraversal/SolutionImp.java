package com.example.BinaryTreeInorderTraversal;

import java.util.*;

class SolutionImp {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new LinkedList<>();

        if (root == null) return result;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left);
            result.add(node.val);
            dfs(node.right);
        }
    }
}
