package com.example.BinaryTreeLevelOrderTraversal;

import java.util.*;

public class Solution {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (root == null) return result;
        next.offer(root);

        while (!next.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> level = new ArrayList<>();
            for (TreeNode n : next) {
                if (n.left != null) temp.offer(n.left);
                if (n.right != null) temp.offer(n.right);
                level.add(n.val);
            }
            next = temp;
            result.add(level);
        }
        return result;
    }
}
