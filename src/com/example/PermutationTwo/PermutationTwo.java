package com.example.PermutationTwo;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PermutationTwo {
    private List<List<Integer>> results;
    private ArrayList<Integer> freq;
    private ArrayList<Integer> indiNums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.results = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return this.results;
        }

        Arrays.sort(nums);
        freq = new ArrayList<Integer>();
        indiNums = new ArrayList<Integer>();

        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            }
            else {
                freq.add(count);
                indiNums.add(nums[i - 1]);
                count = 1;
            }
        }
        freq.add(count);
        indiNums.add(nums[nums.length - 1]);

        List<Integer> result = new ArrayList<>();

        dfs(nums, result, 0);
        return results;
    }

    private void dfs(int[] nums, List<Integer> result, int index) {
        if (index == nums.length) {
            this.results.add(new ArrayList<Integer>(result));
        }
        else {
            for (int i = 0; i < indiNums.size(); i++) {
                if (freq.get(i) > 0) {
                    result.add(indiNums.get(i));
                    freq.set(i, freq.get(i) - 1);
                }
                else {continue;}

                dfs(nums, result, index + 1);
                result.remove(result.size() - 1);
                freq.set(i, freq.get(i) + 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationTwo p = new PermutationTwo();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> results = p.permuteUnique(nums);

        for (List e : results) {
            System.out.println(e);
        }
    }
}
