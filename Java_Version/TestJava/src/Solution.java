/*
Given a m x n grid filled with non-negative numbers, find a path from top left
to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

        Input:
        [
        [1,3,1],
        [1,5,1],
        [4,2,1]
        ]
        Output: 7

        Explanation: Because the path 1→3→1→1→1 minimizes the sum.
*/

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

        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                sumOfPath[row][col] = grid[row][col]
                        + Math.min(sumOfPath[row - 1][col],
                        sumOfPath[row][col - 1]);
            }
        }

        return sumOfPath[sumOfPath.length - 1][sumOfPath[0].length - 1];
    }
}