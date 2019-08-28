package com.example.ConvertSortedArrayToBinarySearchTree;

public class Solution {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        else return tree(nums, 0, nums.length - 1);
    }

    private TreeNode tree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }


        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = tree(nums, low, mid - 1);
        node.right = tree(nums, mid + 1, high);
        return node;
    }
}
