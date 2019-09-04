package com.example.BestTimeToBuyAndSellStockTwo;

public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;

        if (prices.length == 0) return result;
        int lo = prices[0];
        int hi = prices[0];

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > hi) {
                hi = prices[i];
            }
            else {
                result += hi - lo;
                hi = prices[i];
                lo = prices[i];
            }
        }
        return result + hi - lo;
    }
}
