/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

        Example 1:
        Input:
        [[1,1,1],
        [1,0,1],
        [1,1,1]]
        Output:
        [[0, 0, 0],
        [0, 0, 0],
        [0, 0, 0]]
        Explanation:
        For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
        For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
        For the point (1,1): floor(8/9) = floor(0.88888889) = 0
        Note:
        The value in the given matrix is in the range of [0, 255].
        The length and width of the given matrix are in the range of [1, 150].*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        int[][] inpur = {{1}};
        new Solution().imageSmoother(inpur);

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

    public int[][] imageSmoother(int[][] M) {

        if (M == null) {
            return null;
        }

        int rows = M.length;
        int cols = M[0].length;

        int[][] result = new int[rows][cols];
        int tempSum, count;

        int[][] position = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 0}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}};


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                tempSum = 0;
                count = 0;

                for (int i = 0; i < 9; i++) {
                    int currentRow = row + position[i][0];
                    int currentCol = col + position[i][1];

                    if (currentCol < 0 || currentCol >= cols
                            || currentRow < 0 || currentRow >= rows) {
                        continue;
                    }

                    count++;
                    tempSum+=M[currentRow][currentCol];
                }

                result[row][col] = tempSum/count;
            }
        }

        return result;
    }
}