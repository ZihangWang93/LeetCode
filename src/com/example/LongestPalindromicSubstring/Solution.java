package com.example.LongestPalindromicSubstring;

public class Solution {
    int max = 1, start = 0;
    public String longestPalindrome(String s) {

        if (s.length() < 2) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            expand(s, i, i);
            expand(s, i, i+1);
        }

        return s.substring(start, start + max);
    }

    private void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        int count = j - i - 1;
        if (count > max) {
            max = count;
            start = i + 1;
        }
    }
}
