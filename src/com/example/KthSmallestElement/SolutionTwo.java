package com.example.KthSmallestElement;
import java.util.*;
public class SolutionTwo {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] n1, int[] n2) {
                return matrix[n1[0]][n1[1]] - matrix[n2[0]][n2[1]];
            }
        });

        pq.offer(new int[] {0, 0});

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (--k == 0) return matrix[temp[0]][temp[1]];
            if (temp[0] + 1 < matrix.length) pq.offer(new int[]{temp[0] + 1, temp[1]});
            if (temp[0] == 0 &&  temp[1] + 1 < matrix[0].length) pq.offer(new int[] {temp[0], temp[1] + 1});
        }

        return 0;
    }
}
