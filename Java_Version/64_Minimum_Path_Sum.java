/*
  Given a m x n grid filled with non-negative numbers, find a path from top
left to bottom right which minimizes the sum of all numbers along its path.

Note:
  You can only move either down or right at any point in time.

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

    public static void main(String[] args) {

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        System.out.println(new Solution().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] result = new int[grid.length][grid[0].length];

        result[0][0] = grid[0][0];
        for (int col = 1; col < grid[0].length; col++) {
            result[0][col] = grid[0][col] + result[0][col - 1];
        }
        for (int row = 1; row < grid.length; row++) {
            result[row][0] = grid[row][0] + result[row - 1][0];
        }


        for (int row = 1; row < grid.length; row++) {
            for (int col = 1; col < grid[0].length; col++) {
                result[row][col] = grid[row][col]
                        + Math.min(result[row - 1][col], result[row][col - 1]);
            }
        }

        return result[result.length - 1][result[0].length - 1];
    }
}