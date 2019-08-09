package com.example.SameTree;

public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            if (!dfs(p.left, q.left)) {
                return false;
            }
            if (!dfs(p.right, q.right)) {
                return false;
            }
        }

        else if (p == null && q == null) {
            return true;
        }

        else return false;

        return true;
    }
}
