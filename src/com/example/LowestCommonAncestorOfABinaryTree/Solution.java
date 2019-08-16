package com.example.LowestCommonAncestorOfABinaryTree;
import java.util.*;
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        HashSet<TreeNode> parSet = new HashSet<>();
        Queue<TreeNode> next = new LinkedList<>();
        next.offer(root);
        parent.put(root, null);

        while (!next.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();

            for (TreeNode n : next) {
                if (n.left != null) {
                    temp.offer(n.left);
                    parent.put(n.left, n);
                }
                if (n.right != null){
                    temp.offer(n.right);
                    parent.put(n.right, n);
                }
                next = temp;
            }
        }

        while (p != null) {
            parSet.add(p);
            p = parent.get(p);
        }

        while (!parSet.contains(q)) {
            q = parent.get(q);
        }

        return q;

    }
}
