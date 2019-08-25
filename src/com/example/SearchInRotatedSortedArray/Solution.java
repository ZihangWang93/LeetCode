package com.example.SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int low = 0, high = nums.length - 1, n = nums.length - 1;

        while (low < high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] > nums[high]) low = middle + 1;
            else high = middle;
        }

        int index = low;
        if (target <=  nums[n]) {
            low = index;
            high = n;
        }
        else {
            low = 0;
            high = index;
        }

        while (low < high) {
            int middle = low + (high - low) / 2;
            if (target == nums[middle]) return middle;
            if (target > nums[middle]) low = middle + 1;
            else high = middle - 1;
        }

        if (nums[low] == target) return low;
        else return -1;
    }
}
