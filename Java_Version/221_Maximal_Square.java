/*
Given a 2D binary matrix filled with 0's and 1's,
find the largest square containing only 1's and return its area.

        Example:

        Input:

        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0

        Output: 4*/

// Method 1:

/*
class Solution {

    private int result = 0;

    public int maximalSquare(char[][] matrix) {

        if (matrix == null
                || matrix.length == 0 || matrix[0].length == 0) {

            return 0;
        }

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[0].length; col++) {

                if (matrix[row][col] == '1') {

                    maximalSquareHelper(matrix, row, col, row, col);
                }
            }
        }

        return this.result * this.result;
    }

    private void maximalSquareHelper(
            char[][] matrix, int startRow, int startCol,
            int currentRow, int currentCol) {

        if (currentRow >= matrix.length
                || currentCol >= matrix[0].length) {

            result = Math.max(result, currentRow - startRow);
            return;
        }

        for (int col = startCol; col <= currentCol; col++) {

            if (matrix[currentRow][col] == '0') {
                result = Math.max(result, currentRow - startRow);
                return;
            }
        }

        for (int row = startRow; row <= currentRow - 1; row++) {

            if (matrix[row][currentCol] == '0') {
                result = Math.max(result, currentRow - startRow);
                return;
            }
        }

        maximalSquareHelper(matrix, startRow, startCol,
                currentRow + 1, currentCol + 1);
    }
}*/

class Solution {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null
                || matrix.length == 0 || matrix[0].length == 0) {

            return 0;
        }

        int[][] squareLengths
                = new int[matrix.length + 1][matrix[0].length + 1];

        int maxLength = 0;

        for (int row = 1; row < squareLengths.length; row++) {

            for (int col = 1; col < squareLengths[0].length; col++) {

                if (matrix[row - 1][col - 1] == '0') {
                    continue;
                }

                squareLengths[row][col] = 1 + Math.min(
                        squareLengths[row - 1][col - 1],
                        Math.min(squareLengths[row - 1][col],
                                squareLengths[row][col - 1]));

                maxLength = Math.max(maxLength, squareLengths[row][col]);
            }
        }

        return maxLength * maxLength;
    }
}