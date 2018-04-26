/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*
Invert a binary tree.
        4
        /   \
        2     7
        / \   / \
        1   3 6   9
        to
        4
        /   \
        7     2
        / \   / \
        9   6 3   1*/

import sun.plugin.javascript.navig.LinkArray;

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        ListNode result = new Solution().reverseList(root);

        //System.out.println(result);
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
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode rootNode = new TreeNode(root.val);
        rootNode.left = invertTree(root.right);
        rootNode.right = invertTree(root.left);

        return rootNode;
    }
}