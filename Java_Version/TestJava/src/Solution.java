/*
Given a positive integer n, generate a square matrix filled with elements from
1 to n^2 in spiral order.

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

        int[][] result = new int[n][n];

        int num = 1;
        int i;
        int rowStart = 0;
        int rowEnd = n;
        int colStart = 0;
        int colEnd = n;

        while (rowStart < rowEnd && colStart < colEnd) {

            for (i = colStart; i < colEnd; i++) {
                result[rowStart][i] = num++;
            }
            rowStart++;
            for (i = rowStart; i < rowEnd; i++) {
                result[i][colEnd - 1] = num++;
            }
            colEnd--;
            for (i = colEnd - 1; i >= colStart; i--) {
                result[rowEnd - 1][i] = num++;
            }
            rowEnd--;
            for (i = rowEnd - 1; i >= rowStart; i--) {
                result[i][colStart] = num++;
            }
            colStart++;
        }

        return result;
    }
}