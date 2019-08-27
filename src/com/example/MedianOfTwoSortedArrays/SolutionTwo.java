package com.example.MedianOfTwoSortedArrays;

public class SolutionTwo {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = (nums1.length + nums2.length + 1) / 2;
        int r = (nums1.length + nums2.length + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, l) + findKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {   // k is from 1 ~ m + n;
        if (start1 >= nums1.length) return nums2[k + start2 - 1];
        if (start2 >= nums2.length) return nums1[k + start1 - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid = k / 2 ;
        int mid1 = (start1 + mid - 1 >= nums1.length) ? Integer.MAX_VALUE : nums1[start1 + mid - 1];
        int mid2 = (start2 + mid - 1 >= nums2.length) ? Integer.MAX_VALUE : nums2[start2 + mid - 1];

        if (mid1 < mid2) {
            return findKth(nums1, start1 + mid, nums2, start2, k - mid);
        }
        else {
            return findKth(nums1, start1, nums2, start2 + mid, k - mid);
        }
    }
}
