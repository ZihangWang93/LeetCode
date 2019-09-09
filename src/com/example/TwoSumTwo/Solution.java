package com.example.TwoSumTwo;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = 0;
        int end = numbers.length - 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            lo = i + 1;
            hi = end;
            int dif = target - numbers[i];

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (numbers[mid] == dif) return new int[]{i + 1, mid + 1};
                if (numbers[mid] > dif) hi = mid - 1;
                else lo = lo + 1;
            }
            end = hi;
        }
        return new int[]{};
    }
}
