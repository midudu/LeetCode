/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Find the sum of all left leaves in a given binary tree.

        Example:

        3
        / \
        9  20
        /  \
        15   7

        There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.*/


import javax.jws.soap.SOAPBinding;
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

        new Solution().sumOfLeftLeaves(treeNode);

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

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        sumOfLeftLeavesHelper(root.left, 1);
        sumOfLeftLeavesHelper(root.right, -1);

        return result;
    }

    private void sumOfLeftLeavesHelper(TreeNode root, int direction) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (direction == 1) {
                result += root.val;
            }
        } else {
            sumOfLeftLeavesHelper(root.left, 1);
            sumOfLeftLeavesHelper(root.right, -1);
        }
    }
}