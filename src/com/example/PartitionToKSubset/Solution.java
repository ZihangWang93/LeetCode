package com.example.PartitionToKSubset;
import java.util.*;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if (k <= 0 || sum % k != 0) return false;

        int aver = sum / k;
        Arrays.sort(nums);

        int index = nums.length - 1;
        while (index >= 0 && nums[index] == aver) {
            index --;
            k--;
        }

        return search(nums, index, aver, new int[k]);
    }

    private boolean search(int[] nums, int index, int aver, int[] groups) {
        if (index < 0) return true;

        int num = nums[index --];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + num <= aver) {
                groups[i] += num;
                if (search(nums, index, aver, groups)) return true;
                groups[i] -= num;
            }

            if (groups[i] == 0) break;

        }

        return false;
    }
}
