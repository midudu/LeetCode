/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

        Note: You can only move either down or right at any point in time.

        Example:

        Input:
        [
        [1,3,1],
        [1,5,1],
        [4,2,1]
        ]
        Output: 7
        Explanation: Because the path 1→3→1→1→1 minimizes the sum.*/

class Solution {

    public int minPathSum(int[][] grid) {

        if (grid == null ||
                grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] sumOfPath = new int[grid.length][grid[0].length];
        sumOfPath[0][0] = grid[0][0];

        for (int col = 1; col < grid[0].length; col++) {
            sumOfPath[0][col] = grid[0][col] + sumOfPath[0][col - 1];
        }
        for (int row = 1; row < grid.length; row++) {
            sumOfPath[row][0] = grid[row][0] + sumOfPath[row - 1][0];
        }

        minPathSumHelper(1, 1, grid, sumOfPath);

        return sumOfPath[sumOfPath.length - 1][sumOfPath[0].length - 1];
    }

    private void minPathSumHelper(
            int currentRow, int currentCol, int[][] grid,
            int[][] sumOfPath) {

        if (currentRow >= sumOfPath.length || currentCol >= sumOfPath[0].length) {
            return;
        }

        for (int col = currentCol; col < sumOfPath[0].length; col++) {
            sumOfPath[currentRow][col] = grid[currentRow][col]
                    + Math.min(sumOfPath[currentRow - 1][col], sumOfPath[currentRow][col - 1]);
        }
        for (int row = currentRow + 1; row < sumOfPath.length; row++) {
            sumOfPath[row][currentCol] = grid[row][currentCol]
                    + Math.min(sumOfPath[row][currentCol - 1], sumOfPath[row - 1][currentCol]);
        }

        minPathSumHelper(currentRow + 1, currentCol + 1, grid, sumOfPath);
    }
}