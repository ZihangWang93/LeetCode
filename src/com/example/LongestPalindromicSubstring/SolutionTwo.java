package com.example.LongestPalindromicSubstring;

public class SolutionTwo {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        int start = 0;
        int end = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
