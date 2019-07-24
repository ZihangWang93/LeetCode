package com.example.WordSearch;

class Solution {
    boolean[][] isVisited;
    int row, col;

    public boolean exist(char[][] board, String word) {
        if (board == null || word.length() == 0 || word == null) {return false;}

        this.row = board.length;
        this.col = board[0].length;
        this.isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j]) {
                    isVisited[i][j] = true;
                    if (dfs(board, word, 1, i, j)) return true;
                    isVisited[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int length, int row, int col) {
        if (length == word.length()) return true;

        if (isValid(row, col + 1) && !isVisited[row][col + 1] && board[row][col + 1] == word.charAt(length)) {
            isVisited[row][col + 1] = true;
            if (dfs(board, word, length + 1, row, col + 1)) return true;
            isVisited[row][col + 1] = false;
        }

        if (isValid(row, col - 1) && !isVisited[row][col - 1] && board[row][col - 1] == word.charAt(length)) {
            isVisited[row][col - 1] = true;
            if (dfs(board, word, length + 1, row, col - 1)) return true;
            isVisited[row][col - 1] = false;
        }

        if (isValid(row + 1, col) && !isVisited[row + 1][col] && board[row + 1][col] == word.charAt(length)) {
            isVisited[row + 1][col] = true;
            if (dfs(board, word, length + 1, row + 1, col)) return true;
            isVisited[row + 1][col] = false;
        }

        if (isValid(row - 1, col) && !isVisited[row - 1][col] && board[row - 1][col] == word.charAt(length)) {
            isVisited[row - 1][col] = true;
            if (dfs(board, word, length + 1, row - 1, col)) return true;
            isVisited[row - 1][col] = false;
        }

        return false;
    }

    private boolean isValid(int row, int col) {
        if (row >= this.row || row < 0 || col >= this.col || col < 0) return false;
        return true;
    }
}
