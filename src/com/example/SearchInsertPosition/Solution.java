package com.example.SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (target <= nums[start]) return start;
            else return start + 1;
        }
        else if (start > end) return start;

        int middle = start + (end - start) / 2;
        if (nums[middle] == target) return middle;
        else if (nums[middle] < target) return binarySearch(nums, middle + 1, end, target);
        else return binarySearch(nums, start, middle - 1, target);
    }
}
