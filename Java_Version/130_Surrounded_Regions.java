/*
  Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
surrounded by 'X'.

  A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

        X X X X
        X O O X
        X X O X
        X O X X

        After running your function, the board should be:

        X X X X
        X X X X
        X X X X
        X O X X

Explanation:
  Surrounded regions shouldn’t be on the border, which means that any 'O' on
the border of the board are not flipped to 'X'. Any 'O' that is not on the
border and it is not connected to an 'O' on the border will be flipped to 'X'.
  Two cells are connected if they are adjacent cells connected horizontally or
vertically.
*/

class Solution {

    public void solve(char[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        boolean[][] hasVisited = new boolean[board.length][board[0].length];

        processFourEdges(board, hasVisited);

        for (int row = 0; row < hasVisited.length; row++) {
            for (int col = 0; col < hasVisited[row].length; col++) {

                if (board[row][col] == 'O' && !hasVisited[row][col]) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    private void processFourEdges(char[][] board, boolean[][] hasVisited) {

        // left
        for (int row = 0; row < board.length; row++) {

            if (hasVisited[row][0] || board[row][0] == 'X') {
                continue;
            }

            solveHelper(board, hasVisited, row, 0);
        }

        // right
        if (board[0].length != 1) {
            for (int row = 0; row < board.length; row++) {

                if (hasVisited[row][board[0].length - 1]
                        || board[row][board[0].length - 1] == 'X') {
                    continue;
                }

                solveHelper(board, hasVisited, row, board[0].length - 1);
            }
        }

        // up
        for (int col = 1; col < board[0].length - 1; col++) {
            if (hasVisited[0][col] || board[0][col] == 'X') {
                continue;
            }

            solveHelper(board, hasVisited, 0, col);
        }

        // bottom
        if (board.length != 1) {

            for (int col = 1; col < board[0].length - 1; col++) {

                if (hasVisited[board.length - 1][col]
                        || board[board.length - 1][col] == 'X') {

                    continue;
                }

                solveHelper(board, hasVisited, board.length - 1, col);
            }
        }
    }

    private void solveHelper(char[][] board, boolean[][] hasVisited,
                             int currentRow, int currentCol) {

        if (currentRow < 0 || currentRow >= board.length
                || currentCol < 0 || currentCol >= board[0].length) {
            return;
        }
        if (board[currentRow][currentCol] == 'X') {
            return;
        }
        if (hasVisited[currentRow][currentCol]) {
            return;
        }

        hasVisited[currentRow][currentCol] = true;

        solveHelper(board, hasVisited, currentRow - 1, currentCol);
        solveHelper(board, hasVisited, currentRow + 1, currentCol);
        solveHelper(board, hasVisited, currentRow, currentCol - 1);
        solveHelper(board, hasVisited, currentRow, currentCol + 1);
    }
}
