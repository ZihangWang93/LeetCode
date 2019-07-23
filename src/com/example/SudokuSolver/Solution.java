package com.example.SudokuSolver;

public class Solution {
    boolean[][] isVisitedRow;
    boolean[][] isVisitedCol;
    boolean[][] isVisitedBlk;

    public void solveSudoku(char[][] board) {
        isVisitedRow = new boolean[9][9];
        isVisitedCol = new boolean[9][9];
        isVisitedBlk = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int blk = j / 3 + i / 3 * 3;
                    isVisitedRow[i][Character.getNumericValue(board[i][j]) - 1] = true;
                    isVisitedCol[j][Character.getNumericValue(board[i][j]) - 1] = true;
                    isVisitedBlk[blk][Character.getNumericValue(board[i][j]) - 1] = true;
                }
            }
        }

        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }
        else if (board[row][col] != '.') {
            return dfs(board, row + (col + 1) / 9, (col + 1) % 9);
        }
        else {
            int blk = col / 3 + row / 3 * 3;
            for (int i = 0; i < 9; i++) {
                if (!isVisitedRow[row][i] && !isVisitedCol[col][i] && !isVisitedBlk[blk][i]) {
                    board[row][col] = (char) (i + '1');
                    isVisitedRow[row][i] = true;
                    isVisitedCol[col][i] = true;
                    isVisitedBlk[blk][i] = true;
                    if (dfs(board, row + (col + 1) / 9, (col + 1) % 9)) {return  true;}
                    else {
                        board[row][col] = '.';
                        isVisitedRow[row][i] = false;
                        isVisitedCol[col][i] = false;
                        isVisitedBlk[blk][i] = false;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[9][9];
        board[0] = new char[]{'5','3','.','.','7','.','.','.','.'};
        board[1] = new char[]{'6','.','.','1','9','5','.','.','.'};
        board[2] = new char[]{'.','9','8','.','.','.','.','6','.'};
        board[3] = new char[]{'8','.','.','.','6','.','.','.','3'};
        board[4] = new char[]{'4','.','.','8','.','3','.','.','1'};
        board[5] = new char[]{'7','.','.','.','2','.','.','.','6'};
        board[6] = new char[]{'.','6','.','.','.','.','2','8','.'};
        board[7] = new char[]{'.','.','.','4','1','9','.','.','5'};
        board[8] = new char[]{'.','.','.','.','8','.','.','7','9'};
        s.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(board[i]);
        }
    }
}
