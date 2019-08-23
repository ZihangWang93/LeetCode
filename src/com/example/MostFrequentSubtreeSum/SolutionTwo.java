package com.example.MostFrequentSubtreeSum;
import java.util.*;
public class SolutionTwo {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private HashMap<Integer, Integer> sumSet;
    private int max = 0;
    private ArrayList<Integer> result;

    public int[] findFrequentTreeSum(TreeNode root) {
        sumSet = new HashMap<>();
        if (root == null) return new int[0];
        result = new ArrayList<>();
        dfs(root);

        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int val = node.val + left + right;
        int freq = sumSet.getOrDefault(val, 0);
        sumSet.put(val, freq + 1);

        if (max < freq) {
            max = freq;
            result = new ArrayList<>();
            result.add(val);
        }
        else if (max == freq) {
            result.add(val);
        }
        return val;
    }
}
