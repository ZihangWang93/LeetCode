package com.example.CourseSchedule;

import java.util.*;

class SolutionTwo {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        ArrayList[] edges = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]] += 1;
        }

        Queue<Integer> next = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                next.add(i);
                count ++;
            }
        }

        while(!next.isEmpty()) {
            int j = next.remove();
            ArrayList<Integer> arr = edges[j];
            for (int m : arr) {
                inDegree[m] -= 1;
                if (inDegree[m] == 0) {
                    next.add(m);
                    count++;
                }
            }
        }

        if (count == numCourses) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] pre = new int[1][2];
        pre[0] = new int[]{1, 0};
        SolutionTwo s = new SolutionTwo();
        System.out.println(s.canFinish(2, pre));
    }

}