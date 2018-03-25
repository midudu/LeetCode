/*Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

        Example:

        Input: The root of a Binary Search Tree like this:
        5
        /   \
        2     13

        Output: The root of a Greater Tree like this:
        18
        /   \
        20     13*/


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
    private int currentValue = 0;

    public TreeNode convertBST(TreeNode root) {

        convertBSTHelper(root);

        return root;
    }

    private void convertBSTHelper(TreeNode root) {

        if (root == null) {
            return;
        }

        convertBSTHelper(root.right);

        currentValue += root.val;
        root.val = currentValue;

        convertBSTHelper(root.left);
    }
}