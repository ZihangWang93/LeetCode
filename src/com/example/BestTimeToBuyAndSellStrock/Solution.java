package com.example.BestTimeToBuyAndSellStrock;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0];
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = prices[i] - min > max ? prices[i] - min : max;
        }

        return max;
    }
}
