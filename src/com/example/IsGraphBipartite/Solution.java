package com.example.IsGraphBipartite;

import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        HashSet<Integer> isVisitedOne = new HashSet<Integer>();
        HashSet<Integer> isVisitedTwo = new HashSet<Integer>();

        Queue<Integer> next = new LinkedList<Integer>();
        for (int i = 0; i < graph.length; i++) {
            if (!isVisitedOne.contains(i) && !isVisitedTwo.contains(i)) {
                next.add(i);
                int oneOrTwo = 1;
                while (!next.isEmpty()) {
                    Queue<Integer> temp = new LinkedList<>();
                    if (oneOrTwo == 1) {
                        for (int j : next) {
                            if (isVisitedTwo.contains(j)) return false;
                            else if (isVisitedOne.contains(j)) continue;
                            else {
                                isVisitedOne.add(j);
                                for (int k : graph[j]) {
                                    temp.add(k);
                                }
                            }
                        }
                        oneOrTwo = 2;
                    }

                    else {
                        for (int j : next) {
                            if (isVisitedOne.contains(j)) return false;
                            else if (isVisitedTwo.contains(j)) continue;
                            else {
                                isVisitedTwo.add(j);
                                for (int k : graph[j]) {
                                    temp.add(k);
                                }
                            }
                        }
                        oneOrTwo = 1;
                    }
                    next = temp;
                }
            }
        }
        return true;
    }
}
