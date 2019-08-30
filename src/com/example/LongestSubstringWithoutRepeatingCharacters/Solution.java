package com.example.LongestSubstringWithoutRepeatingCharacters;

import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, set.size());
            }
            else {
                set.remove(s.charAt(i++));
            }
        }

        return result;
    }
}
