package com.example.IsGraphBipartite;

import java.util.*;

class SolutionTwo {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        Queue<Integer> next = new LinkedList<Integer>();
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                next.offer(i);
                color[i] = 1;
                while (!next.isEmpty()) {

                    int cur = next.poll();

                    for (int adj : graph[cur]) {
                        if (color[adj] == color[cur]) return false;
                        else if (color[adj] == 0) {
                            color[adj] = -1 * color[cur];
                            next.offer(adj);
                        }
                    }
                }
            }
        }
        return true;
    }
}
