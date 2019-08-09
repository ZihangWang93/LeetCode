package com.example.BinaryTreeInorderTraversal;

import java.util.*;

class Solution {
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
        if (node.left == null) {
            result.add(node.val);
            if (node.right != null) {
                dfs(node.right);
            }
            return;
        }

        dfs(node.left);
        result.add(node.val);

        if (node.right != null) {
            dfs(node.right);
        }
    }
}
