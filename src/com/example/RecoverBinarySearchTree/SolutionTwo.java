package com.example.RecoverBinarySearchTree;

public class SolutionTwo {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode fir = null;
    TreeNode sec = null;
    TreeNode pre = null;

    public void recoverTree(TreeNode root) {
        mtr(root);
        int t = fir.val;
        fir.val = sec.val;
        sec.val = t;
    }

    private void mtr(TreeNode node) {
        TreeNode cur = node;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode t = cur.left;

                while (t.right != null && t.right != cur) {
                    t = t.right;
                }

                if (t.right == null) {
                    t.right = cur;
                    cur = cur.left;
                }
                else {
                    t.right = null;
                    op(cur);
                    cur = cur.right;
                }
            }
            else {
                op(cur);
                cur = cur.right;
            }

        }
    }

    private void op(TreeNode cur) {
        if (pre != null && pre.val > cur.val) {
            if (fir == null) {
                fir = pre;
            }
            sec = cur;
        }
        pre = cur;
    }
}
