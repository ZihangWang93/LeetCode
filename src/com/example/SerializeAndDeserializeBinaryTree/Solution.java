package com.example.SerializeAndDeserializeBinaryTree;
import java.util.*;
public class Solution {
      public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
      }

    public String serialize(TreeNode root) {
        return dfs(root, new StringBuilder()).toString();
    }

    private StringBuilder dfs (TreeNode n, StringBuilder s) {
        if (n == null) return s.append("N,");
        s.append(n.val).append(",");
        dfs(n.left, s);
        dfs(n.right, s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return de(q);
    }
    private TreeNode de(Queue<String> q) {
        String s = q.poll();
        if (s.equals("N")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = de(q);
        root.right = de(q);
        return root;
    }
}
