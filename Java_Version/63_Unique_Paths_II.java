/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

        The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

        Now consider if some obstacles are added to the grids. How many unique paths would there be?



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

        uniquePathsWithObstaclesHelper(0, 0,
                obstacleGrid, numbersOfPaths);

        return numbersOfPaths[numbersOfPaths.length - 1][numbersOfPaths[0].length - 1];
    }

    private void uniquePathsWithObstaclesHelper(
            int currentRow, int currentCol, int[][] obstacleGrid, int[][] numberOfPaths) {

        if (currentRow >= numberOfPaths.length
                || currentCol >= numberOfPaths[0].length) {
            return;
        }

        for (int col = currentCol; col < numberOfPaths[0].length; col++) {

            if (obstacleGrid[currentRow][col] == 1) {
                numberOfPaths[currentRow][col] = 0;
                continue;
            }

            if (col != 0) {
                numberOfPaths[currentRow][col] += numberOfPaths[currentRow][col - 1];
            }
            if (currentRow != 0) {
                numberOfPaths[currentRow][col] += numberOfPaths[currentRow - 1][col];
            }
        }

        for (int row = currentRow + 1; row < numberOfPaths.length; row++) {

            if (obstacleGrid[row][currentCol] == 1) {
                numberOfPaths[row][currentCol] = 0;
                continue;
            }

            if (currentCol != 0) {
                numberOfPaths[row][currentCol] += numberOfPaths[row][currentCol - 1];
            }

            if (row != 0) {
                numberOfPaths[row][currentCol] += numberOfPaths[row - 1][currentCol];
            }
        }

        uniquePathsWithObstaclesHelper(currentRow + 1, currentCol + 1,
                obstacleGrid, numberOfPaths);
    }
}