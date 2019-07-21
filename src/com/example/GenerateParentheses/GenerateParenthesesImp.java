package com.example.GenerateParentheses;

import java.util.List;
import java.util.ArrayList;

public class GenerateParenthesesImp {
    List<String> results;
    public List<String> generateParenthesis(int n) {
        this.results = new ArrayList<String>();

        if (n == 0) {
            return this.results;
        }

        dfs("", n, 0);
        return this.results;
    }

    private void dfs(String s, int left, int right) {
        if (left == 0 && right == 0) {
            this.results.add(s);
            return;
        }

        if (left > 0) {
            dfs(s + '(', left - 1, right + 1);
        }

        if (right > 0) {
            dfs(s + ')', left, right - 1);
        }
    }
}
