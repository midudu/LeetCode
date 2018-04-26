/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a binary tree, return all root-to-leaf paths.

        For example, given the following binary tree:

        1
        /   \
        2     3
        \
        5
        All root-to-leaf paths are:

        ["1->2->5", "1->3"]*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        StringBuilder a = new StringBuilder("ha");
        StringBuilder b = a;
        a.append("haha");

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

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return result;
        }

        binaryTreePathsHelper(root, new StringBuilder(""));

        return result;
    }

    private void binaryTreePathsHelper(TreeNode root, StringBuilder path) {

        if (root.left != null) {
            StringBuilder leftString = new StringBuilder(path);
            binaryTreePathsHelper(root.left, leftString.append(Integer.toString(root.val)).append("->"));
        }
        if (root.right != null) {
            StringBuilder rightString = new StringBuilder(path);
            binaryTreePathsHelper(root.right, rightString.append(Integer.toString(root.val)).append("->"));
        }

        if (root.left == null && root.right == null) {
            result.add(path.append(Integer.toString(root.val)).toString());
        }
    }
}