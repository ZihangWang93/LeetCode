package com.example.SingleNumber;
import java.util.*;
public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }
            else {
                set.add(nums[i]);
            }
        }
        for (int j : set) {
            return j;
        }
        throw new IllegalArgumentException();
    }
}
