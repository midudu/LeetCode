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
                {1, 1},
                {1, 0}
        };
        int[] answer = new Solution().calc_max_match_lengths("ababaa");

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
    public int repeatedStringMatch(String A, String B) {

        String ACopy = new String(A);

        int result = 1;
        while (A.length() < B.length()) {

            A += ACopy;
            result++;
        }

        if (A.contains(B)) {
            return result;
        }

        A += ACopy;
        if (A.contains(B)) {
            return result + 1;
        }else {
            return -1;
        }

    }
}