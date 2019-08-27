package com.example.KthSmallestElementInABST;
import java.util.*;
public class Solution {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> tree = new Stack<>();

        while (true) {

            while (root != null) {
                tree.push(root);
                root = root.left;
            }

            TreeNode node = tree.pop();
            root = node.right;

            if (--k == 0) return node.val;
        }
    }
}
