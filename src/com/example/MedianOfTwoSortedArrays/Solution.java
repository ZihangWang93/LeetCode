package com.example.MedianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int lo = 0;
        int hi = m;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int other = (m + n + 1) / 2 - mid;

            int left1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid - 1];
            int right1 = (mid == m) ? Integer.MAX_VALUE : nums1[mid];
            int left2 = (other == 0) ? Integer.MIN_VALUE : nums2[other - 1];
            int right2 = (other == n) ? Integer.MAX_VALUE : nums2[other];

            if (left1 <= right2 && right1 >= left2) {
                if ((m + n) % 2 == 0) {
                    return(Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                else return Math.max(left1, left2);
            }
            else if (left1 > right2) hi = mid - 1;
            else lo = mid + 1;
        }

        throw new IllegalArgumentException();
    }
}
