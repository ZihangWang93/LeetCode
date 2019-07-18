package com.example.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                List<Integer> result = new ArrayList<>();
                result.add(candidates[i]);
                int[] left = new int[candidates.length - i];
                System.arraycopy(candidates, i, left, 0, left.length);

                dfs(left, target - candidates[i], result);
            }
        }
        return this.results;
    }

    private void dfs(int[] candidates, int target, List<Integer> result) {
        if (target == 0) {
            this.results.add(result);
        }

        else {
            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }

                else {
                    int[] left = new int[candidates.length - i];
                    System.arraycopy(candidates, i, left, 0, left.length);
                    List<Integer> temp = new ArrayList<>(result);
                    temp.add(candidates[i]);
                    dfs(left, target - candidates[i], temp);
                }
            }
        }
    }

    public static void main(String args[]) {
        int target = 10;
        int[] candidates = new int[]{1, 2, 3, 4, 5};
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> resutts = combinationSum.combinationSum(candidates, target);
        for (List i : resutts) {
            System.out.println(i);
        }
    }
}
