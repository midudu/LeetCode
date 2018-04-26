/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

        Now given an M x N matrix, return True if and only if the matrix is Toeplitz.


        Example 1:

        Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
        Output: True
        Explanation:
        1234
        5123
        9512

        In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
        Example 2:

        Input: matrix = [[1,2],[2,2]]
        Output: False
        Explanation:
        The diagonal "[1, 2]" has different elements.
        Note:

        matrix will be a 2D array of integers.
        matrix will have a number of rows and columns in range [1, 20].
        matrix[i][j] will be integers in range [0, 99].*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        String[] input = {"5", "2", "C", "D", "+"};

        Solution solution = new Solution();
        int receive = solution.calPoints(input);


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
    public boolean isToeplitzMatrix(int[][] matrix) {

        if (matrix == null || matrix.length <= 1) {
            return true;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {

                if ( matrix[row][col] != matrix[row+1][col+1]){
                    return false;
                }
            }
        }

        return true;
    }
}