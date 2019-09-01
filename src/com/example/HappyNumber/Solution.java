package com.example.HappyNumber;
import java.util.*;
public class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (n == 1) return true;

        int sum = 0;
        if (set.add(n)) {
            while (n > 0) {
                int res = n % 10;
                sum += res * res;
                n = n / 10;
            }
        }
        else return false;
        return isHappy(sum);
    }
}
