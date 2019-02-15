/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle
defined by its upper left corner (row1, col1) and lower right corner
(row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1)
and (row2, col2) = (4, 3), which contains sum = 8.

Example:

    Given matrix = [
        [3, 0, 1, 4, 2],
        [5, 6, 3, 2, 1],
        [1, 2, 0, 1, 5],
        [4, 1, 0, 1, 7],
        [1, 0, 3, 0, 5]
        ]

        sumRegion(2, 1, 4, 3) -> 8
        sumRegion(1, 1, 2, 2) -> 11
        sumRegion(1, 2, 2, 4) -> 12

Note:
        You may assume that the matrix does not change.
        There are many calls to sumRegion function.
        You may assume that row1 ≤ row2 and col1 ≤ col2.*/


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

class NumMatrix {

    private int[][] sumFromFirst;

    public NumMatrix(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            sumFromFirst = null;
            return;
        }

        sumFromFirst = new int[matrix.length][matrix[0].length];

        sumFromFirst[0][0] = matrix[0][0];

        for (int col = 1; col < matrix[0].length; col++) {
            sumFromFirst[0][col] = sumFromFirst[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < matrix.length; row++) {
            sumFromFirst[row][0] = sumFromFirst[row - 1][0] + matrix[row][0];
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {

                sumFromFirst[row][col] = sumFromFirst[row - 1][col]
                        - sumFromFirst[row - 1][col - 1]
                        + sumFromFirst[row][col - 1] + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (sumFromFirst == null) {
            return 0;
        }

        if (row1 == 0 && col1 == 0) {
            return sumFromFirst[row2][col2];
        } else if (row1 == 0) {
            return sumFromFirst[row2][col2] - sumFromFirst[row2][col1 - 1];
        } else if (col1 == 0) {
            return sumFromFirst[row2][col2] - sumFromFirst[row1 - 1][col2];
        } else {
            return sumFromFirst[row2][col2] -
                    (sumFromFirst[row2][col1 - 1]
                            - sumFromFirst[row1 - 1][col1 - 1]
                            + sumFromFirst[row1 - 1][col2]);
        }
    }
}

