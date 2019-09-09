package com.example.TrappingRainWater;

public class SolutionTwo {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int result = 0;

        while (left < right) {
            if (height[left] > height[right]) {
                if (height[right] > maxRight) {
                    maxRight = height[right];
                }
                else { result += maxRight - height[right];}
                right--;
            }
            else {

                if (height[left] > maxLeft) {
                    maxLeft = height[left];
                }
                else {result += maxLeft - height[left];}
                left++;
            }
        }

        return result;
    }
}
