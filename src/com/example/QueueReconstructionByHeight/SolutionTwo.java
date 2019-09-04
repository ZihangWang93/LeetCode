package com.example.QueueReconstructionByHeight;
import java.util.*;
public class SolutionTwo {
    public int[][] reconstructQueue(int[][] people) {

        if (people.length == 0) return new int[0][0];

        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return b[0] - a[0];
            }
        });

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            result.add(people[i][1], people[i]);
        }
        return result.toArray(new int[people.length][2]);
    }
}
