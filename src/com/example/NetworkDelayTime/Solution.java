package com.example.NetworkDelayTime;

import javafx.util.Pair;
import java.util.*;

class Solution {
    private ArrayList<Pair<Integer, Integer>>[] graph;
    private int[] result;

    public int networkDelayTime(int[][] times, int N, int K) {
        graph = new ArrayList[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            result[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        result[K] = 0;

        for (int i = 0; i < times.length; i++) {
            graph[times[i][0]].add(new Pair(times[i][1], times[i][2]));
        }

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getValue() - p2.getValue();
            }
        });

        pq.add(new Pair(K, 0));

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int node = (Integer)temp.getKey();
            relax(node, pq);
        }

        int max = 0;
        for (int i = 1; i < N + 1; i ++) {
            if (result[i] > max) {
                max = result[i];
            }
        }

        if (max == Integer.MAX_VALUE) {
            return -1;
        }

        return max;
    }

    private void relax(int node, PriorityQueue<Pair<Integer, Integer>> pq) {
        for (Pair i : graph[node]) {
            int adj = (Integer)i.getKey();
            int adjValue = (Integer)i.getValue();
            if (result[node] + adjValue < result[adj]) {
                result[adj] = result[node] + adjValue;
                pq.add(new Pair(adj, result[adj]));
            }
        }
    }
}