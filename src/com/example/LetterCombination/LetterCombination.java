package com.example.LetterCombination;

import java.util.ArrayList;
import java.util.List;
public class LetterCombination {
    private List<String> results;

    public List<String> letterCombinations(String digits) {
        this.results = new ArrayList<>();
        if (digits.length() == 0) {
            return this.results;
        }

        char[] table = new char[]{'a','d','g','j','m','p','t','w'};

        StringBuilder s = new StringBuilder();
        dfs(s, table, digits, 0);
        return results;
    }

    private void dfs(StringBuilder s, char[] table, String digits, int index) {
        if (index == digits.length()) {
            StringBuilder st = new StringBuilder(s);
            this.results.add(st.toString());
        }
        else {
            char c = digits.charAt(index);
            int numLength = 0;
            if (Character.getNumericValue(c) == 7 || Character.getNumericValue(c) == 9) {
                numLength = 4;
            }
            else {
                numLength = 3;
            }

            for (int j = 0; j < numLength; j++) {
                s.append((char)(table[Character.getNumericValue(c) - 2] + j));
                dfs(s, table, digits, ++index);
                s.deleteCharAt(s.length() - 1);
                index--;
            }
        }
    }

    public static void main (String[] args) {
        LetterCombination lc = new LetterCombination();
        String s = "234";
        List<String> result = lc.letterCombinations(s);

        for (String st : result) {
            System.out.println(st);
        }
    }
}
