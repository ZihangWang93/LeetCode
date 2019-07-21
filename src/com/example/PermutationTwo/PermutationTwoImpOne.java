package com.example.PermutationTwo;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PermutationTwoImpOne {
    List<List<Integer>> results;
    boolean[] isVisited;

    public List<List<Integer>> permuteUnique(int[] nums) {

        this.results = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return this.results;
        }

        Arrays.sort(nums);
        this.isVisited = new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>(), 0);

        return this.results;
    }

    private void dfs(int[] nums, ArrayList<Integer> result, int index) {
        if (index == nums.length) {
            this.results.add(new ArrayList<Integer>(result));
            return;
        }

        else {
            for (int i = 0; i < nums.length; i++) {
                if (isVisited[i] || i > 0 && nums[i - 1] == nums[i] && !isVisited[i - 1]) {
                    continue;
                }

                isVisited[i] = true;
                result.add(nums[i]);
                dfs(nums, result, index + 1);

                result.remove(result.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}
