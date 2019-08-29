package com.example.FindModeInBinarySearchTree;
import java.util.*;
public class Solution {

    ArrayList<Integer> arr = new ArrayList<>();
    int f = -1;
    int count = 0;
    int val;

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        val = root.val;
        dfs(root);
        int[] result = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }
        return result;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);

        if (node.val == val) {
            count++;
        }
        else {
            count = 1;
            val = node.val;
        }

        if (count == f) {
            arr.add(node.val);
        }
        else if (count > f) {
            arr = new ArrayList<>();
            arr.add(node.val);
            f = count;
        }

        dfs(node.right);
    }
}
