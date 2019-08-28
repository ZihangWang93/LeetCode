package com.example.RecoverBinarySearchTree;
import java.util.*;
public class Solution {


    private ArrayList<Integer> arr= new ArrayList<>();
    private int first;
    private int second;

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public void recoverTree(TreeNode root) {
        dfs(root);
        int index = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                first = arr.get(i);
                second = arr.get(i + 1);
                index = i + 1;
                break;
            }
        }

        for (int i = index; i < arr.size() - 1; i++) {
            if (arr.get(i) > arr.get(i + 1)) {
                second = arr.get(i + 1);
                break;
            }
        }

        dfsRecover(root);
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        arr.add(node.val);
        dfs(node.right);
    }

    private void dfsRecover(TreeNode node) {
        if (node == null) return;
        dfsRecover(node.left);


        if (node.val == first) node.val = second;
        else if (node.val == second) node.val = first;

        dfsRecover(node.right);
    }
}
