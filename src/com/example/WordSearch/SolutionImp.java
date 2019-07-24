package com.example.WordSearch;

public class SolutionImp {
    int row, col;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word.length() == 0 || word == null) return false;

        this.row = board.length;
        this.col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, 0, i, j)) return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int length, int row, int col) {
        if (length == word.length()) return true;

        if (row < 0 || row >= this.row || col < 0 || col >= this.col || board[row][col] != word.charAt(length)) {
            return false;
        }

        board[row][col] += 100;

        if (dfs(board, word, length+1, row+1, col) || dfs(board, word, length+1, row-1, col) || dfs(board, word, length+1, row, col+1) || dfs(board, word, length+1, row, col-1)) {
            return true;
        }

        board[row][col] -= 100;

        return false;
    }
}
