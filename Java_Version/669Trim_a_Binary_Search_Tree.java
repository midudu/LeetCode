/*Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

        Example 1:
        Input:
        1
        / \
        0   2

        L = 1
        R = 2

        Output:
        1
        \
        2
        Example 2:
        Input:
        3
        / \
        0   4
        \
        2
        /
        1

        L = 1
        R = 3

        Output:
        3
        /
        2
        /
        1*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 5, 3, 5, 1, -5, 1, -2};

        Solution solution = new Solution();
        int receive = solution.findComplement(5);


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
    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) {
            return null;
        }

        if (root.val > R) {

            return trimBST(root.left, L, R);
        } else if (root.val < L) {

            return trimBST(root.right, L, R);
        }

        TreeNode resultTreeNode =  new TreeNode(root.val);
        resultTreeNode.left = trimBST(root.left, L, R);
        resultTreeNode.right = trimBST(root.right, L, R);

        return resultTreeNode;
    }
}