/*
  Write a program to solve a Sudoku puzzle by filling the empty cells.

  A sudoku solution must satisfy all of the following rules:
    1. Each of the digits 1-9 must occur exactly once in each row.
    2. Each of the digits 1-9 must occur exactly once in each column.
    3. Each of the the digits 1-9 must occur exactly once in each of the 9 3x3
    sub-boxes of the grid.

  Empty cells are indicated by the character '.'.

Note:
  1. The given board contain only digits 1-9 and the character '.'.
  2. You may assume that the given Sudoku puzzle will have a single unique solution.
  3. The given board size is always 9x9.
*/

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        new Solution().solveSudoku(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public void solveSudoku(char[][] board) {
        dfs(board, 0, 0);
    }

    private boolean dfs(char[][] board, int row, int col) {

        if (col >= 9) {
            return dfs(board, row + 1, 0);
        }

        if (row >= 9) {
            return true;
        }

        if (board[row][col] != '.') {
            return dfs(board, row, col + 1);
        }

        for (char currentNum = '1'; currentNum <= '9'; currentNum++) {

            if (isValid(board, row, col, currentNum)) {

                board[row][col] = currentNum;
                if (dfs(board, row, col + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }

        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {

        for (int i = 0; i < 9; i++) {

            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }

        return true;
    }
}
