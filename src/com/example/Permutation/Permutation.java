package com.example.Permutation;

import java.util.List;
import java.util.ArrayList;

public class Permutation {
    private List<List<Integer>> results;

    public List<List<Integer>> permute(int[] nums) {
        this.results = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return results;
        }

        List<Integer> result = new ArrayList<Integer>();
        findPermutation(nums, result, nums.length - 1);

        return results;
    }

    private void findPermutation(int[] nums, List<Integer> result, int index) {
        if (index == 0) {
            result.add(nums[0]);
            this.results.add(new ArrayList(result));
            result.remove(result.size() - 1);
        }

        else {
            for (int i = 0; i <= index; i++) {
                result.add(nums[i]);
                int temp = nums[i];
                nums[i] = nums[index];
                findPermutation(nums, result, --index);
                result.remove(result.size() - 1);
                nums[i] = temp;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        Permutation p = new Permutation();
        List<List<Integer>> results = p.permute(nums);
        for (List<Integer> e : results) {
            System.out.println(e);
        }
    }
}
