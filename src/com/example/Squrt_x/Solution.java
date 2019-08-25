package com.example.Squrt_x;

public class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int low = 0, high = x;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            int div = x / middle;

            if (div == middle) return middle;
            if (div > middle) {
                low = middle + 1;
            }
            else high = middle - 1;
        }
        return high;
    }
}
