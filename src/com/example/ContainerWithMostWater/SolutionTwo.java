package com.example.ContainerWithMostWater;

public class SolutionTwo {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while(i < j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max((j - i) * h, max);

            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return max;
    }
}
