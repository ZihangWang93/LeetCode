package com.example.NetworkDelayTime;

import java.util.*;

public class SolutionImp {
    private int[][] graph;
    private int[] result;
    private boolean[] visited;

    public int networkDelayTime(int[][] times, int N, int K) {
        graph = new int[N + 1][N + 1];
        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(graph[i], -1);
        }
        Arrays.fill(result, Integer.MAX_VALUE);
        result[K] = 0;

        for (int i = 0; i < times.length; i++) {
            graph[times[i][0]][times[i][1]] = times[i][2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });

        pq.offer(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int node = temp[0];

            if (visited[node]) continue;
            visited[node] = true;

            for (int i = 0; i < N + 1; i++) {
                if (graph[node][i] != -1 && result[i] > result[node] + graph[node][i]) {
                    result[i] = result[node] + graph[node][i];
                    pq.add(new int[]{i, result[i]});
                }
            }
        }

        int max = 0;
        for (int i = 1; i < N + 1; i ++) {
            max = Math.max(max, result[i]);
        }

        if (max == Integer.MAX_VALUE) {
            return -1;
        }

        return max;
    }
}
