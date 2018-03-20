/*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


        Example:

        Given the sorted array: [-10,-3,0,5,9],

        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

        0
        / \
        -3   9
        /   /
        -10  5*/


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
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums == null || nums.length < 1)
            return null;

        int numsLength = nums.length;

        return sortedArrayToBSTHelper(nums, 0, numsLength - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        } else if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }

        int mid = (startIndex + endIndex) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTHelper(nums, startIndex, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, endIndex);

        return root;
    }
}