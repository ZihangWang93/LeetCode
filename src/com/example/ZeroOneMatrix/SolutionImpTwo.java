package com.example.ZeroOneMatrix;

public class SolutionImpTwo {
    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dis = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                }
                else {
                    int left = (j > 0) ? dis[i][j - 1] : row + col;
                    int up = (i > 0) ? dis[i - 1][j] : row + col;
                    dis[i][j] = Math.min(left, up) + 1;
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    dis[i][j] = 0;
                }
                else{
                    int right = (j < col - 1) ? dis[i][j + 1] : dis[i][j];
                    int down = (i < row - 1) ? dis[i + 1][j] : dis[i][j];
                    dis[i][j] = Math.min(Math.min(right, down) + 1, dis[i][j]);
                }

            }
        }

        return dis;
    }
}
