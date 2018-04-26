/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

        Example:
        Given a binary tree
        1
        / \
        2   3
        / \
        4   5
        Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

        Note: The length of path between two nodes is represented by the number of edges between them.*/


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
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        result = Math.max(result, leftDepth + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}