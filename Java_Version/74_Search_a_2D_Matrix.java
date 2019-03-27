/*
Write an efficient algorithm that searches for a value in an m x n matrix. This
matrix has the following properties:

  Integers in each row are sorted from left to right.
  The first integer of each row is greater than the last integer of the previous row.

        Example 1:

        Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 3
        Output: true

        Example 2:

        Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 13
        Output: false
*/

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = searchRow(matrix, target);

        if (row == -1) {
            return false;
        }

        return searchCol(matrix, row, target);
    }

    private int searchRow(int[][] matrix, int target) {

        int startRow = 0, endRow = matrix.length - 1;

        while (startRow < endRow - 1) {

            int middleRow = startRow + (endRow - startRow) / 2;

            if (matrix[middleRow][0] == target) {
                return middleRow;
            } else if (matrix[middleRow][0] < target) {
                startRow = middleRow;
            } else {
                endRow = middleRow - 1;
            }
        }

        if (endRow < startRow) {
            return -1;
        }

        return (matrix[endRow][0] <= target ? endRow :
                (matrix[startRow][0] <= target ? startRow : -1));
    }

    private boolean searchCol(int[][] matrix, int row, int target) {

        int startCol = 0, endCol = matrix[row].length - 1;

        while (startCol <= endCol) {

            int middleCol = startCol + (endCol - startCol) / 2;
            if (matrix[row][middleCol] == target) {
                return true;
            } else if (matrix[row][middleCol] < target) {
                startCol = middleCol + 1;
            } else {
                endCol = middleCol - 1;
            }
        }

        return false;
    }
}