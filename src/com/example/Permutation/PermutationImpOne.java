package com.example.Permutation;

import java.util.List;
import java.util.ArrayList;

public class PermutationImpOne {
    private List<List<Integer>> results;
    private boolean[] isVisited;

    public List<List<Integer>> permute(int[] nums) {
        this.results = new ArrayList<>();
        this.isVisited = new boolean[nums.length];

        if (nums == null || nums.length == 0) {
            return results;
        }

        List<Integer> result = new ArrayList<Integer>();
        findPermutation(nums, result, 0);

        return results;
    }

    private void findPermutation(int[] nums, List<Integer> result, int index) {
        if (index == nums.length) {
            this.results.add(new ArrayList(result));
        }

        else {
            for (int i = 0; i < nums.length; i++) {
                if (isVisited[i]) {
                    continue;
                }
                result.add(nums[i]);
                isVisited[i] = true;
                findPermutation(nums, result, index + 1);
                result.remove(result.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}
