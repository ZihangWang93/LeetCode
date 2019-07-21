package com.example.GenerateParentheses;

import java.util.List;
import java.util.ArrayList;

public class GenerateParenthesesOne {
    List<String> results;
    int[] freq;
    public List<String> generateParenthesis(int n) {
        this.results = new ArrayList<String>();
        this.freq = new int[]{n, n};

        if (n == 0) {
            return this.results;
        }

        StringBuilder s = new StringBuilder();

        dfs(s, 2 * n, 0);
        return this.results;
    }

    private void dfs(StringBuilder s, int length, int index) {
        if (index == length) {
            this.results.add(new String(s.toString()));
        }

        else {
            char[] c = new char[]{'(', ')'};

            if (freq[0] < freq[1] && freq[0] > 0) {
                for (int i = 0; i < 2; i++) {
                    s.append(c[i]);
                    freq[i]--;
                    dfs(s, length, index + 1);
                    s.deleteCharAt(s.length() - 1);
                    freq[i]++;
                }
            }
            else if (freq[0] == 0) {
                s.append(c[1]);
                freq[1]--;
                dfs(s, length, index + 1);
                s.deleteCharAt(s.length() - 1);
                freq[1]++;
            }
            else {
                s.append(c[0]);
                freq[0]--;
                dfs(s, length, index + 1);
                s.deleteCharAt(s.length() - 1);
                freq[0]++;
            }
        }
    }
}
