package com.example.IsGraphBipartite;

import java.util.*;

class SolutionThree {
    int[] color;
    public boolean isBipartite(int[][] graph) {
        color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                if (!dfs(graph, i)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int start) {
        for (int adj : graph[start]) {
            if (color[adj] == color[start]) return false;
            else if(color[adj] == 0) {
                color[adj] = -color[start];
                if (!dfs(graph, adj)) return false;
            }
        }
        return true;
    }
}
