package com.example.CourseSchedule;

import java.util.*;

public class SolutionImp {
    private boolean[] isVisited;
    private boolean[] noLoop;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        ArrayList[] edges = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            edges[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        isVisited = new boolean[numCourses];
        noLoop = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(edges, i)) return false;
        }

        return true;
    }

    private boolean dfs(ArrayList<Integer>[] edges, int index) {

        if (isVisited[index]) { return false;}

        if (noLoop[index] || edges[index].size() == 0) {
            return true;
        }

        isVisited[index] = true;
        for (int i : edges[index]) {
            if (!dfs(edges, i)) {
                return false;
            }
        }

        isVisited[index] = false;
        noLoop[index] = true;
        return true;
    }
}
