package com.example.ZeroOneMatrix;

import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int[][] dis = new int[row][col];

        Queue<Integer> next = new LinkedList<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                    isVisited[i][j] = true;
                    next.add(col * i + j);
                }
            }
        }

        int d = 1;
        while (!next.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            for (int i : next) {
                int r = i / col;
                int c = i % col;
                if ((c + 1) < col && !isVisited[r][c + 1]) {
                    isVisited[r][c + 1] = true;
                    dis[r][c + 1] = d;
                    temp.add(i + 1);
                }

                if ((c - 1) >= 0 && !isVisited[r][c - 1]) {
                    isVisited[r][c - 1] = true;
                    dis[r][c - 1] = d;
                    temp.add(i - 1);
                }

                if (r + 1 < row && !isVisited[r + 1][c]) {
                    isVisited[r + 1][c] = true;
                    dis[r + 1][c] = d;
                    temp.add(i + col);
                }

                if (r - 1 >= 0 && !isVisited[r - 1][c]) {
                    isVisited[r - 1][c] = true;
                    dis[r - 1][c] = d;
                    temp.add(i - col);
                }
            }

            next = temp;
            d++;
        }
        return dis;
    }

    public static void main(String[] args) {
        int [][] input = new int[5][5];
        input[0] = new int[] {0, 1, 0, 1, 1};
        input[1] = new int[] {1, 1, 0, 0, 1};
        input[2] = new int[] {0, 0, 0, 1, 0};
        input[3] = new int[] {1, 0, 1, 1, 1};
        input[4] = new int[] {1, 0, 0, 0, 1};
        Solution s = new Solution();
        int[][] result = s.updateMatrix(input);
        for (int[] arr : result) {
            for (int temp : arr) {
                System.out.print(Integer.toString(temp) + ' ');
            }
            System.out.println('\n');
        }
    }
}
