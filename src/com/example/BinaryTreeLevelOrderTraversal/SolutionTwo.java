package com.example.BinaryTreeLevelOrderTraversal;

import java.util.*;

public class SolutionTwo {
    private List<List<Integer>> result;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, 0);

        return result;
    }

    private void dfs(TreeNode node, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }

        result.get(level).add(node.val);

        if (node.left != null) {
            dfs(node.left, level + 1);
        }

        if (node.right != null) {
            dfs(node.right, level + 1);
        }
    }
}
