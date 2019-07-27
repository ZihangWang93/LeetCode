package com.example.KeysAndRooms;

import java.util.*;

public class Solution {
    private boolean[] isVisited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        isVisited = new boolean[rooms.size()];
        if (rooms == null || rooms.size() ==0) return false;

        dfs (rooms, 0);
        isVisited[0] = true;

        for (int i = 0; i < rooms.size(); i++) {
            if (!isVisited[i]) return false;
        }

        return true;
    }

    private void dfs(List<List<Integer>> rooms, int index) {
        for (int i : rooms.get(index)) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                dfs(rooms, i);
            }
        }
        return;
    }
}
