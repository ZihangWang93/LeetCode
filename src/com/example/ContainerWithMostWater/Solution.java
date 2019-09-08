package com.example.ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int vol = (j - i) * Math.min(height[i], height[j]);
                if (vol > max) max = vol;
            }
        }
        return max;
    }
}
