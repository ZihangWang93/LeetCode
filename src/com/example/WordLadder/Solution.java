package com.example.WordLadder;

import java.util.*;

class Solution {
    HashMap<String, Boolean> isVisited;
    HashSet<String> wordHashSet;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) return 0;

        this.wordHashSet = new HashSet(wordList);
        this.isVisited = new HashMap<String, Boolean>();

        for (int i = 0; i < wordList.size(); i++) {
            isVisited.put(wordList.get(i), false);
        }

        LinkedList<String> beginWords = new LinkedList<>();
        beginWords.add(beginWord);

        int length = dfs(beginWords, endWord, 1);
        return length;
    }

    private int dfs (LinkedList<String> beginWords, String endWord, int l) {
        if (l > wordHashSet.size() + 2 || beginWords.size() == 0) return 0;

        LinkedList<String> words = new LinkedList<String>();

        for (int m = 0; m < beginWords.size(); m++) {
            String s = beginWords.get(m);

            if (s.equals(endWord)) return l;
            for (int i = 0; i < s.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String temp = s.substring(0, i) + c + s.substring(i+1);
                    if (wordHashSet.contains(temp) && !isVisited.get(temp) ) {
                        words.add(temp);
                        isVisited.put(temp, true);
                    }
                }
            }
        }
        return dfs(words, endWord, l+1);
    }
}