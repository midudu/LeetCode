/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

        You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

        Example 1:
        Input:
        Tree 1                     Tree 2
        1                         2
        / \                       / \
        3   2                     1   3
        /                           \   \
        5                             4   7
        Output:
        Merged tree:
        3
        / \
        4   5
        / \   \
        5   4   7
        Note: The merging process must start from the root nodes of both trees.*/

import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) {
        int[] nums = {5, 5, 3, 5, 1, -5, 1, -2};

        Solution solution = new Solution();
        List<List<Integer>> receive = solution.fourSum(nums, 4);


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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode resultTree = null;

        if (t1 == null) {

            resultTree = new TreeNode(t2.val);
            resultTree.left = this.mergeTrees(null, t2.left);
            resultTree.right = this.mergeTrees(null, t2.right);

        } else if (t2 == null) {

            resultTree = new TreeNode(t1.val);
            resultTree.left = this.mergeTrees(t1.left, null);
            resultTree.right = this.mergeTrees(t1.right, null);

        } else {

            resultTree = new TreeNode(t1.val + t2.val);
            resultTree.left = this.mergeTrees(t1.left, t2.left);
            resultTree.right = this.mergeTrees(t1.right, t2.right);
        }

        return resultTree;
    }


}