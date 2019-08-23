package com.example.MostFrequentSubtreeSum;

import java.util.*;

public class solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private HashMap<Integer, Integer> sumSet;
    public int[] findFrequentTreeSum(TreeNode root) {
        sumSet = new HashMap<>();

        if (root == null) return new int[0];
        int temp = dfs(root);

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] h1, int[] h2) {
                return h2[1] - h1[1];
            }
        });

        for (int i : sumSet.keySet()) {
            pq.add(new int []{i, sumSet.get(i)});
        }

        ArrayList<Integer> result = new ArrayList<>();
        int[] first = pq.poll();
        result.add(first[0]);
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            if (next[1] == first[1]) { result.add(next[0]);}
            else break;
        }

        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int result = node.val + dfs(node.left) + dfs(node.right);
        int freq = sumSet.getOrDefault(result, 0);
        sumSet.put(result, freq + 1);
        return result;
    }
}
