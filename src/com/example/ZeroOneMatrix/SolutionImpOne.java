package com.example.ZeroOneMatrix;

import java.util.*;

public class SolutionImpOne {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dis = new int[row][col];

        Queue<Integer> next = new LinkedList<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                    next.add(col * i + j);
                }
                else {
                    dis[i][j] = row + col;
                }
            }
        }

        int d = 1;
        while (!next.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            for (int i : next) {
                int r = i / col;
                int c = i % col;
                if ((c + 1) < col && dis[r][c + 1] > d) {
                    dis[r][c + 1] = d;
                    temp.add(i + 1);
                }

                if ((c - 1) >= 0 && dis[r][c - 1] > d) {
                    dis[r][c - 1] = d;
                    temp.add(i - 1);
                }

                if (r + 1 < row && dis[r + 1][c] > d) {
                    dis[r + 1][c] = d;
                    temp.add(i + col);
                }

                if (r - 1 >= 0 && dis[r - 1][c] > d) {
                    dis[r - 1][c] = d;
                    temp.add(i - col);
                }
            }

            next = temp;
            d++;
        }
        return dis;
    }
}
