/*
  The n-queens puzzle is the problem of placing n queens on an n×n chessboard
such that no two queens attack each other.

  Given an integer n, return all distinct solutions to the n-queens puzzle.

  Each solution contains a distinct board configuration of the n-queens'
placement, where 'Q' and '.' both indicate a queen and an empty space
respectively.

Example:

        Input: 4
        Output:
        [
        [".Q..",  // Solution 1
        "...Q",
        "Q...",
        "..Q."],

        ["..Q.",  // Solution 2
        "Q...",
        "...Q",
        ".Q.."]
        ]

        Explanation:
          There exist two distinct solutions to the 4-queens puzzle as shown above.*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        List<List<String>> result = new Solution().solveNQueens(3);

        System.out.println();
    }

    public List<List<String>> solveNQueens(int n) {

        if (n < 1) {
            return new ArrayList<>();
        }

        boolean[][] currentBoard = new boolean[n][n];

        List<List<String>> result = new ArrayList<>();

        solveNQueensHelper(currentBoard, result, 0);

        return result;
    }

    private void solveNQueensHelper(boolean[][] board, List<List<String>> result, int currentRow) {

        if (currentRow == board.length) {
            result.add(formatBoard(board));
            return;
        }

        for (int col = 0; col < board[currentRow].length; col++) {

            if (!canCurrentPositionPlaceQueen(board, currentRow, col)) {
                continue;
            }

            board[currentRow][col] = true;
            solveNQueensHelper(board, result, currentRow + 1);
            board[currentRow][col] = false;
        }
    }

    private boolean canCurrentPositionPlaceQueen(boolean[][] board, int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col]) {
                return false;
            }
        }

        for (int i = 1; ; i++) {
            int currentRow = row - i;
            int currentCol = col - i;
            if (currentRow < 0 || currentCol < 0) {
                break;
            }

            if (board[currentRow][currentCol]) {
                return false;
            }
        }

        for (int i = 1; ; i++) {
            int currentRow = row - i;
            int currentCol = col + i;
            if (currentRow < 0 || currentCol >= board.length) {
                break;
            }

            if (board[currentRow][currentCol]) {
                return false;
            }
        }

        return true;
    }

    private List<String> formatBoard(boolean[][] board) {

        List<String> result = new ArrayList<>(board.length);

        for (int row = 0; row < board.length; row++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int col = 0; col < board[row].length; col++) {
                char c = (board[row][col] ? 'Q' : '.');
                stringBuilder.append(c);
            }
            result.add(stringBuilder.toString());
        }

        return result;
    }
}
