/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

        Example:

        Input: 3
        Output:
        [
        [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]
        ]
        */

class Solution {

    public int[][] generateMatrix(int n) {

        if (n <= 0) {
            return null;
        }

        int[][] result = new int[n][n];

        generateMatrixHelper(0, result.length - 1,
                0, result[0].length - 1,
                1, result);

        return result;
    }

    private void generateMatrixHelper(
            int startRow, int endRow, int startCol, int endCol,
            int currentNum, int[][] result) {
				

        if (startRow > endRow || startCol > endCol) {
            return;
        }

        for (int col = startCol; col <= endCol; col++) {
            result[startRow][col] = currentNum;
            currentNum++;
        }

        for (int row = startRow + 1; row <= endRow; row++) {
            result[row][endCol] = currentNum;
            currentNum++;
        }

        if (startRow != endRow) {
            for (int col = endCol - 1; col >= startCol; col--) {
                result[endRow][col] = currentNum;
                currentNum++;
            }
        }

        if (startCol != endCol) {
            for (int row = endRow - 1; row >= startRow + 1; row--) {
                result[row][startCol] = currentNum;
                currentNum++;
            }
        }

        generateMatrixHelper(startRow + 1, endRow - 1,
                startCol + 1, endCol - 1,
                currentNum, result);
    }
}