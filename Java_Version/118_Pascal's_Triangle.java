/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given numRows, generate the first numRows of Pascal's triangle.

        For example, given numRows = 5,
        Return

        [
        [1],
        [1,1],
        [1,2,1],
        [1,3,3,1],
        [1,4,6,4,1]
        ]*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = new Solution().isSymmetric(root);

        System.out.println(result);
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
    public List<List<Integer>> generate(int numRows) {

        if (numRows <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<Integer>(1);
        firstRow.add(1);
        result.add(firstRow);
        if (numRows == 1) {
            return result;
        }

        List<Integer> secondRow = new ArrayList<Integer>(2);
        secondRow.add(1);
        secondRow.add(1);
        result.add(secondRow);
        if (numRows == 2) {
            return result;
        }

        for (int row = 3; row <= numRows; row++) {
            List<Integer> tempRow = new ArrayList<Integer>(row);
            tempRow.add(1);
            int size = result.get(row - 2).size();
            for (int col = 1; col < size; col++) {
                tempRow.add(result.get(row - 2).get(col) + result.get(row - 2).get(col - 1));
            }
            tempRow.add(1);
            result.add(tempRow);
        }

        return result;
    }
}