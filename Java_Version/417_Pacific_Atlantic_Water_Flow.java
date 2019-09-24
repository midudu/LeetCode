/*
  Given an m x n matrix of non-negative integers representing the height of
each unit cell in a continent, the "Pacific ocean" touches the left and top
edges of the matrix and the "Atlantic ocean" touches the right and bottom
edges.

  Water can only flow in four directions (up, down, left, or right) from a cell
to another one with height equal or lower.

  Find the list of grid coordinates where water can flow to both the Pacific
and Atlantic ocean.

Note:
  1. The order of returned grid coordinates does not matter.
  2. Both m and n are less than 150.

Example:

        Given the following 5x5 matrix:

        Pacific ~   ~   ~   ~   ~
             ~  1   2   2   3  (5) *
             ~  3   2   3  (4) (4) *
             ~  2   4  (5)  3   1  *
             ~ (6) (7)  1   4   5  *
             ~ (5)  1   1   2   4  *
                *   *   *   *   * Atlantic

        Return:

        [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
        (positions with parentheses in above matrix).
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};

        List<List<Integer>> lists = new Solution().pacificAtlantic(matrix);

        System.out.println();
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        boolean[][] isPacificable = new boolean[matrix.length][matrix[0].length];
        initIsPacificableTable(isPacificable);

        boolean[][] isAtlanticable = new boolean[matrix.length][matrix[0].length];
        initIsAtlanticableTable(isAtlanticable);

        dfs(matrix, isPacificable);
        dfs(matrix, isAtlanticable);

        generateResult(isPacificable, isAtlanticable, result);


        return result;
    }

    private void initIsPacificableTable(boolean[][] isPacificable) {

        for (int row = 0; row < isPacificable.length; row++) {
            isPacificable[row][0] = true;
        }
        for (int col = 0; col < isPacificable[0].length; col++) {
            isPacificable[0][col] = true;
        }
    }

    private void initIsAtlanticableTable(boolean[][] isAtlanticable) {

        for (int row = 0; row < isAtlanticable.length; row++) {
            isAtlanticable[row][isAtlanticable[0].length - 1] = true;
        }
        for (int col = 0; col < isAtlanticable[0].length; col++) {
            isAtlanticable[isAtlanticable.length - 1][col] = true;
        }
    }

    private void generateResult(
            boolean[][] isPacificable, boolean[][] isAtlanticable,
            List<List<Integer>> result) {

        for (int row = 0; row < isPacificable.length; row++) {
            for (int col = 0; col < isPacificable[0].length; col++) {
                if (isPacificable[row][col] && isAtlanticable[row][col]) {
                    List<Integer> currentResult = new ArrayList<>();
                    currentResult.add(row);
                    currentResult.add(col);
                    result.add(currentResult);
                }
            }
        }
    }

    private void dfs(int[][] matrix, boolean[][] table) {

        boolean[][] hasVisited = new boolean[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (table[row][col]) {
                    dfsHelper(matrix, table, hasVisited, row, col);
                }
            }
        }
    }

    private void dfsHelper(
            int[][] matrix, boolean[][] table, boolean[][] hasVisited,
            int currentRow, int currentCol) {

        if (hasVisited[currentRow][currentCol]) {
            return;
        }

        hasVisited[currentRow][currentCol] = true;
        table[currentRow][currentCol] = true;

        if (currentRow >= 1 &&
                matrix[currentRow - 1][currentCol] >= matrix[currentRow][currentCol]) {
            dfsHelper(matrix, table, hasVisited, currentRow - 1, currentCol);
        }
        if (currentRow < matrix.length - 1 &&
                matrix[currentRow + 1][currentCol] >= matrix[currentRow][currentCol]) {
            dfsHelper(matrix, table, hasVisited, currentRow + 1, currentCol);
        }

        if (currentCol >= 1 &&
                matrix[currentRow][currentCol - 1] >= matrix[currentRow][currentCol]) {
            dfsHelper(matrix, table, hasVisited, currentRow, currentCol - 1);
        }
        if (currentCol < matrix[0].length - 1 &&
                matrix[currentRow][currentCol + 1] >= matrix[currentRow][currentCol]) {
            dfsHelper(matrix, table, hasVisited, currentRow, currentCol + 1);
        }
    }
}
