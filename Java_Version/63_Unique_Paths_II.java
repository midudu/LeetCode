/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in
the diagram below).

The robot can only move either down or right at any point in time. The robot is
trying to reach the bottom-right corner of the grid (marked 'Finish' in the
diagram below).

Now consider if some obstacles are added to the grids. How many unique paths
would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

        Example 1:

        Input:
        [
        [0,0,0],
        [0,1,0],
        [0,0,0]
        ]
        Output: 2

        Explanation:
        There is one obstacle in the middle of the 3x3 grid above.
        There are two ways to reach the bottom-right corner:
        1. Right -> Right -> Down -> Down
        2. Down -> Down -> Right -> Right*/

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null
                || obstacleGrid.length == 0 || obstacleGrid[0].length == 0
                || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] numbersOfPaths
                = new int[obstacleGrid.length][obstacleGrid[0].length];
        numbersOfPaths[0][0] = 1;

        for (int row = 1; row < numbersOfPaths.length; row++) {
            if (obstacleGrid[row][0] == 1 || numbersOfPaths[row - 1][0] == 0) {
                numbersOfPaths[row][0] = 0;
            } else {
                numbersOfPaths[row][0] = 1;
            }
        }

        for (int col = 1; col < numbersOfPaths[0].length; col++) {

            if (obstacleGrid[0][col] == 1 || numbersOfPaths[0][col - 1] == 0) {
                numbersOfPaths[0][col] = 0;
            } else {
                numbersOfPaths[0][col] = 1;
            }
        }

        for (int row = 1; row < numbersOfPaths.length; row++) {
            for (int col = 1; col < numbersOfPaths[0].length; col++) {

                if (obstacleGrid[row][col] == 1) {
                    numbersOfPaths[row][col] = 0;
                } else {
                    numbersOfPaths[row][col] =
                            numbersOfPaths[row - 1][col] + numbersOfPaths[row][col - 1];
                }
            }
        }


        return numbersOfPaths[numbersOfPaths.length - 1][numbersOfPaths[0].length - 1];
    }


}