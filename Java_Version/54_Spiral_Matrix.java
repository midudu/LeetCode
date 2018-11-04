/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

        Example 1:

        Input:
        [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
        ]
        Output: [1,2,3,6,9,8,7,4,5]
        Example 2:

        Input:
        [
        [1, 2, 3, 4],
        [5, 6, 7, 8],
        [9,10,11,12]
        ]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        spiralOrderHelper(matrix, 0, matrix.length - 1,
                0, matrix[0].length - 1, result);

        return result;
    }

    private void spiralOrderHelper(
            int[][] matrix, int startRow, int endRow,
            int startCol, int endCol, List<Integer> result) {

        if (startRow > endRow || startCol > endCol) {
            return;
        }

        for (int col = startCol; col <= endCol; col++) {
            result.add(matrix[startRow][col]);
        }

        for (int row = startRow + 1; row <= endRow; row++) {
            result.add(matrix[row][endCol]);
        }

        if (endRow != startRow) {
            for (int col = endCol - 1; col >= startCol; col--) {
                result.add(matrix[endRow][col]);
            }
        }

        if (endCol != startCol) {
            for (int row = endRow - 1; row > startRow; row--) {
                result.add(matrix[row][startCol]);
            }
        }

        spiralOrderHelper(matrix, startRow + 1, endRow - 1,
                startCol + 1, endCol - 1, result);
    }
}