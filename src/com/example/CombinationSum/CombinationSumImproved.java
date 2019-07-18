package com.example.CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumImproved {
    private List<List<Integer>> results;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results = new ArrayList<>();
        if (candidates == null || candidates.length == 0){
            return this.results;
        }

        Arrays.sort(candidates);
        List<Integer> result = new ArrayList<>();

        dfs(0, candidates, target, result);
        return this.results;
    }

    private void dfs(int starter, int[] candidates, int target, List<Integer> result) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(result);
            this.results.add(temp);
        }

        else {
            for (int i = starter; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    break;
                }

                else {
                    result.add(candidates[i]);
                    dfs(i, candidates, target - candidates[i], result);
                    result.remove(result.size() - 1);
                }
            }
        }
    }

    public static void main(String args[]) {
        int target = 10;
        int[] candidates = new int[]{1, 2, 3, 4, 5};
        CombinationSumImproved combinationSum = new CombinationSumImproved();
        List<List<Integer>> results = combinationSum.combinationSum(candidates, target);
        for (List i : results) {
            System.out.println(i);
        }
    }
}
