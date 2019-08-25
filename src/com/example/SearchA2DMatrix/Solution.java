package com.example.SearchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0, high = row * col - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int row_id = middle / col;
            int col_id = middle % col;

            if (matrix[row_id][col_id] == target) return true;
            if (matrix[row_id][col_id] > target) high = middle - 1;
            else low = middle + 1;
        }
        return false;
    }
}
