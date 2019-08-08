package com.example.RedundantConnection;

class Solution {
    private int[] ancestors;

    public int[] findRedundantConnection(int[][] edges) {
        ancestors = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            ancestors[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int nodeOne = edges[i][0];
            int nodeTwo = edges[i][1];

            int ancOne = find(nodeOne);
            int ancTwo = find(nodeTwo);

            if (ancOne == ancTwo) {
                return edges[i];
            }
            else {
                ancestors[ancTwo] = ancOne;
            }
        }

        return null;
    }

    private int find(int node) {
        if (ancestors[node] == node) return node;
        int par = ancestors[node];
        ancestors[node] = ancestors[par];
        return find(par);
    }
}
