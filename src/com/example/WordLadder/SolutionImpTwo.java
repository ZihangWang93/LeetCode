package com.example.WordLadder;

import java.util.*;

public class SolutionImpTwo {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();

        if (!wordSet.contains(endWord)) return 0;
        int length = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);
        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        while(!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            HashSet<String> newSet = new HashSet<String>();
            for(String st : beginSet) {
                char[] ch = st.toCharArray();
                for (int i = 0; i < st.length(); i++) {
                    char curr = ch[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String newSt = String.valueOf(ch);
                        if (endSet.contains(newSt)) return length + 1;
                        if (wordSet.contains(newSt)) {
                            newSet.add(newSt);
                            wordSet.remove(newSt);
                        }
                    }
                    ch[i] = curr;
                }
            }
            beginSet = newSet;
            length += 1;
        }
        return 0;
    }
}
