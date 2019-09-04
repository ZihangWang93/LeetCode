package com.example.QueueReconstructionByHeight;
import java.util.*;
public class Solution {
    public int[][] reconstructQueue(int[][] people) {

        if (people.length == 0) return new int[0][0];
        int[][] result = new int[people.length][2];

        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return b[1] - a[1];
                else return a[0] - b[0];
            }
        });

        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            index.add(i);
        }

        for (int i = 0; i < people.length; i++) {
            int pos = index.get(people[i][1]);
            result[pos] = people[i];
            index.remove(people[i][1]);
        }
        return result;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        int[][] arr = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(s.reconstructQueue(arr));
    }
}
