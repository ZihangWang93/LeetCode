package com.example.WordLadder;

import java.util.*;

public class SolutionImpOne {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();

        if (!wordSet.contains(endWord)) return 0;
        int length = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);

        while(!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            HashSet<String> newSet = new HashSet<String>();
            for(String st : beginSet) {
                for (int i = 0; i < st.length(); i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String newSt = st.substring(0, i) + c + st.substring(i + 1);
                        if (endSet.contains(newSt)) return length + 1;
                        if (wordSet.contains(newSt)) {
                            newSet.add(newSt);
                            wordSet.remove(newSt);
                        }
                    }
                }
            }
            beginSet = newSet;
            length += 1;
        }
        return 0;
    }
}
