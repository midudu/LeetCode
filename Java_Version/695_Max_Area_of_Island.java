/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

        Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

        Example 1:
        [[0,0,1,0,0,0,0,1,0,0,0,0,0],
        [0,0,0,0,0,0,0,1,1,1,0,0,0],
        [0,1,1,0,1,0,0,0,0,0,0,0,0],
        [0,1,0,0,1,1,0,0,1,0,1,0,0],
        [0,1,0,0,1,1,0,0,1,1,1,0,0],
        [0,0,0,0,0,0,0,0,0,0,1,0,0],
        [0,0,0,0,0,0,0,1,1,1,0,0,0],
        [0,0,0,0,0,0,0,1,1,0,0,0,0]]
        Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
        Example 2:
        [[0,0,0,0,0,0,0,0]]
        Given the above grid, return 0.
        Note: The length of each dimension in the given grid does not exceed 50.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        int[][] input = {
                {1,1},
                {1,0}
        };
        int answer = new Solution().maxAreaOfIsland(input);

        System.out.println("haha");
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    private int rows, cols;
    private int[][] flag;
    private int result = 0;
    private Integer count;

    public int maxAreaOfIsland(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;
        flag = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                count = 0;
                maxAreaOfIslandHelper(grid, row, col);
            }
        }

        return result;
    }

    private void maxAreaOfIslandHelper(int[][] grid, int row, int col) {

        if (row >= 0 && row < rows && col >= 0 && col < cols
                && grid[row][col] == 1 && flag[row][col] != 1) {

            count++;
            flag[row][col] = 1;

            maxAreaOfIslandHelper(grid, row, col - 1);
            maxAreaOfIslandHelper(grid, row, col + 1);
            maxAreaOfIslandHelper(grid, row - 1, col);
            maxAreaOfIslandHelper(grid, row + 1, col);

            result = Math.max(result, count);
        }
    }
}