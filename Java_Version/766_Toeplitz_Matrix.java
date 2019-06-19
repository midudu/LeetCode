/*
  A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
same element.

  Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

Example 1:

        Input:
        matrix = [
        [1,2,3,4],
        [5,1,2,3],
        [9,5,1,2]
        ]
        Output: True

        Explanation:
        In the above grid, the diagonals are:
        "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
        In each diagonal all elements are the same, so the answer is True.

Example 2:

        Input:
        matrix = [
        [1,2],
        [2,2]
        ]
        Output: False

        Explanation:
        The diagonal "[1, 2]" has different elements.

Note:

        matrix will be a 2D array of integers.
        matrix will have a number of rows and columns in range [1, 20].
        matrix[i][j] will be integers in range [0, 99].

Follow up:

        What if the matrix is stored on disk, and the memory is limited such
      that you can only load at most one row of the matrix into the memory at
      once?

        What if the matrix is so large that you can only load up a partial row
      into the memory at once?
*/

class Solution {

    public boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int row = 1; row < matrix.length; row++) {

            if (!isToeplitzMatrixHelper(matrix, row, 0)) {
                return false;
            }
        }

        for (int col = 0; col < matrix[0].length; col++) {

            if (!isToeplitzMatrixHelper(matrix,0, col)) {
                return false;
            }
        }

        return true;
    }

    private boolean isToeplitzMatrixHelper(int[][] matrix, int startRow, int startCol) {

        int value = matrix[startRow][startCol];

        for (int row = startRow + 1, col = startCol + 1;
             row < matrix.length && col < matrix[0].length; row++, col++) {

            if (matrix[row][col] != value) {
                return false;
            }
        }

        return true;
    }
}