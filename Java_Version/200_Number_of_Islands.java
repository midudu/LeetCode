/*
Given a 2d grid map of '1's (land) and '0's (water),
count the number of islands.
An island is surrounded by water and is formed
by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

        Example 1:

        Input:
        11110
        11010
        11000
        00000

        Output: 1

        Example 2:

        Input:
        11000
        11000
        00100
        00011

        Output: 3*/

class Solution {

    public int numIslands(char[][] grid) {

        if (grid == null
                || grid.length == 0 || grid[0].length == 0) {

            return 0;
        }

        int result = 0;

        boolean[][] hasVisited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (hasVisited[row][col] || grid[row][col] == '0') {
                    continue;
                }
                result++;

                numIslandsHelper(grid, row, col, hasVisited);
            }
        }

        return result;
    }

    private void numIslandsHelper(
            char[][] grid, int currentRow, int currentCol,
            boolean[][] hasVisited) {

        if (currentRow < 0 || currentRow >= grid.length) {
            return;
        }
        if (currentCol < 0 || currentCol >= grid[0].length) {
            return;
        }

        if (hasVisited[currentRow][currentCol]) {
            return;
        }

        if (grid[currentRow][currentCol] == '0') {
            return;
        }

        hasVisited[currentRow][currentCol] = true;

        numIslandsHelper(grid, currentRow - 1, currentCol, hasVisited);
        numIslandsHelper(grid, currentRow + 1, currentCol, hasVisited);
        numIslandsHelper(grid, currentRow, currentCol - 1, hasVisited);
        numIslandsHelper(grid, currentRow, currentCol + 1, hasVisited);
    }
}