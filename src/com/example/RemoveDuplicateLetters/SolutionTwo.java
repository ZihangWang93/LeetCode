package com.example.RemoveDuplicateLetters;
import java.util.*;
public class SolutionTwo {
    public String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            count[index]--;

            if (visited[index]) continue;

            while(!stack.isEmpty() && s.charAt(i) < stack.peek() && count[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(s.charAt(i));
            visited[s.charAt(i) - 'a'] = true;
        }

        StringBuilder st = new StringBuilder();
        for (char c : stack) {
            st.append(c);
        }

        return st.toString();
    }
}
