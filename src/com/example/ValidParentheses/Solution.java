package com.example.ValidParentheses;
import java.util.*;
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else if (stack.isEmpty()) return false;
            else if (s.charAt(i) == ')') {
                if (stack.pop() != '(') return false;
            }
            else if (s.charAt(i) == '}') {
                if (stack.pop() != '{') return false;
            }
            else {
                if (stack.pop() != '[') return false;
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
