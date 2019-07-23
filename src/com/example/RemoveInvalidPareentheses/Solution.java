package com.example.RemoveInvalidPareentheses;

import java.util.*;

class Solution {
    private List<String> result;
    public List<String> removeInvalidParentheses(String s) {
        result = new ArrayList<String>();

        if (s == null || s.length() == 0) {
            result.add("");
            return result;
        }

        deleteInvalid(s, 0, 0, new char[]{'(', ')'});

        return result;
    }

    private void deleteInvalid(String s, int loopStart, int deleteStart, char[] sign) {
        for (int i = loopStart, count = 0; i < s.length(); i++) {
            if (s.charAt(i) == sign[0]) {count++;}
            if (s.charAt(i) == sign[1]) {count--;}

            if (count >= 0) {continue;}
            else {
                for (int j = deleteStart; j <= i; j++) {
                    if (s.charAt(j) == sign[1] && (j == deleteStart || s.charAt(j - 1) != sign[1])) {
                        deleteInvalid(s.substring(0, j) + s.substring(j + 1), i , j, sign);
                    }
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (sign[0] == '(') {
            deleteInvalid(reversed, 0, 0, new char[]{')', '('});
        }
        else {
            result.add(reversed);
        }
    }
}
