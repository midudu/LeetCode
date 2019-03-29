/*
  Given a 2D board and a word, find if the word exists in the grid.

  The word can be constructed from letters of sequentially adjacent cell,
where "adjacent" cells are those horizontally or vertically neighboring.

  The same letter cell may not be used more than once.

        Example:

        board =
        [
        ['A','B','C','E'],
        ['S','F','C','S'],
        ['A','D','E','E']
        ]

        Given word = "ABCCED", return true.
        Given word = "SEE", return true.
        Given word = "ABCB", return false.*/

class Solution {


    public boolean exist(char[][] board, String word) {

        if (word == null || word.isEmpty()) {
            return true;
        }

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] hasVisited
                = new boolean[board.length][board[0].length];

        char firstChar = word.charAt(0);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                if (board[row][col] == firstChar) {

                    boolean findFlag
                            = existHelper(board, word, row, col,
                            0, hasVisited);

                    if (findFlag) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean existHelper(
            char[][] board, String word,
            int currentRow, int currentCol,
            int wordIndex, boolean[][] hasVisited) {

        if (currentCol < 0 || currentCol >= board[0].length
                || currentRow < 0 || currentRow >= board.length) {
            return false;
        }

        if (hasVisited[currentRow][currentCol]) {
            return false;
        }

        if (board[currentRow][currentCol] != word.charAt(wordIndex)) {
            return false;
        }

        if (wordIndex == word.length() - 1) {
            return true;
        }

        hasVisited[currentRow][currentCol] = true;

        boolean result = existHelper(board, word, currentRow + 1, currentCol,
                wordIndex + 1, hasVisited)
                || existHelper(board, word, currentRow - 1, currentCol,
                wordIndex + 1, hasVisited)
                || existHelper(board, word, currentRow, currentCol - 1,
                wordIndex + 1, hasVisited)
                || existHelper(board, word, currentRow, currentCol + 1,
                wordIndex + 1, hasVisited);

        hasVisited[currentRow][currentCol] = false;

        return result;
    }
}