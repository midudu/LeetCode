/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

        You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

        The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

        If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

        Example 1:
        Input:
        nums =
        [[1,2],
        [3,4]]
        r = 1, c = 4
        Output:
        [[1,2,3,4]]
        Explanation:
        The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
        Example 2:
        Input:
        nums =
        [[1,2],
        [3,4]]
        r = 2, c = 4
        Output:
        [[1,2],
        [3,4]]
        Explanation:
        There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
        Note:
        The height and width of the given matrix is in range [1, 100].
        The given r and c are all positive.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        int[] ints = {3, 1, 4, 1, 5};
        new Solution().findPairs(ints, 2);

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
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int originalRows = nums.length;
        int originalCols = nums[0].length;

        if (originalCols * originalRows != r * c) {
            return nums;
        }

        int[][] result = new int[r][c];
        int originRowPointer = 0, originColPointer = 0;

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {

                result[row][col] = nums[originRowPointer][originColPointer];
                originColPointer++;
                if (originColPointer == originalCols) {
                    originColPointer = 0;
                    originRowPointer++;
                }
            }
        }

        return result;
    }
}