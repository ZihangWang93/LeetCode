package com.example.TrappingRainWater;
import java.util.*;
public class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;

        Stack<int[]> stack = new Stack<>();

        int result = 0;
        int start = 1;
        while (start < height.length && height[start] >= height[start - 1]) {start++;}
        stack.push(new int[]{start - 1, height[start - 1]});


        for (int i = start; i < height.length; i++) {
            int[] peek = stack.peek();
            if (height[i] <= peek[1]) {
                stack.push(new int[]{i, height[i]});
            }
            else {
                while (stack.size() >= 2 && height[i] >= peek[1]) {
                    int[] toAdd = stack.pop();
                    peek = stack.peek();
                    result += Math.max(Math.min(height[i], peek[1]) - toAdd[1], 0) * (i - peek[0] - 1);
                }
                stack.add(new int[]{i, height[i]});
            }
        }

        return result;
    }
}
