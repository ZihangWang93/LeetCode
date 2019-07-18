package com.example.LetterCombination;

import java.util.ArrayList;
import java.util.List;
public class LetterCombinationImpOne {
    private List<String> results;

    public List<String> letterCombinations(String digits) {
        this.results = new ArrayList<>();
        if (digits.length() == 0 || digits == null) {
            return this.results;
        }

        String[] table = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        results.add("");
        for (int i = 0; i < digits.length(); i++) {
            results = combine(table[digits.charAt(i) - '0'], results);
        }
        return results;
    }

    private List<String> combine(String s, List<String> result) {
        List<String> temp = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            for (String st : result) {
                temp.add(st + s.charAt(i));
            }
        }
        return temp;
    }
}
