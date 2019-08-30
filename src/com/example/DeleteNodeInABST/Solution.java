package com.example.DeleteNodeInABST;

public class Solution {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right =deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                TreeNode small = findMin(root.right);
                root.right = deleteMin(root.right);
                small.left = root.left;
                small.right = root.right;
                return small;
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node;
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left != null) {
            node.left = deleteMin(node.left);
        }
        else return node.right;

        return node;
    }
}
