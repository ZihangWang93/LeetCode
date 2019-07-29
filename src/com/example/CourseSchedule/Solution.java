package com.example.CourseSchedule;

import java.util.*;

public class Solution {
    private boolean[] isVisited;
    private boolean[] noLoop;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> l = edges.getOrDefault(prerequisites[i][0], new LinkedList<Integer>());
            l.add(prerequisites[i][1]);
            edges.put(prerequisites[i][0], l);
        }

        isVisited = new boolean[numCourses];
        noLoop = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(edges, i)) return false;
        }

        return true;
    }

    private boolean dfs(HashMap<Integer, List<Integer>> edges, int index) {

        if (noLoop[index]) {return true;}

        if (isVisited[index]) { return false;}
        isVisited[index] = true;

        if ( edges.get(index) == null || edges.get(index).size() == 0) {
            isVisited[index] = false;
            noLoop[index] = true;
            return true;
        }

        for (int i : edges.get(index)) {
            if (!dfs(edges, i)) {
                return false;
            }
            else {
                noLoop[i] = true;
                isVisited[i] = false;
            }
        }

        isVisited[index] = false;
        noLoop[index] = true;

        return true;
    }

    public static void main(String[] args) {
        int[][] pre = new int[2][2];
        pre[0] = new int[]{0, 1};
        pre[1] = new int[]{1, 0};
        Solution s = new Solution();
        System.out.println(s.canFinish(2, pre));
    }
}
