/*Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than or equal to the node's key.
        The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
        Both the left and right subtrees must also be binary search trees.
        For example:
        Given BST [1,null,2,2],
        1
        \
        2
        /
        2
        return [2].

        Note: If a tree has more than one mode, you can return them in any order.

        Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).*/


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

        new Solution().countSegments("   f");

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
    List<Integer> result = new ArrayList<>();
    Integer currentValue = null;
    int mode = 0;
    int currentMode = 0;

    public int[] findMode(TreeNode root) {

        if (root == null) {
            return new int[0];
        }

        preOrderTraversal(root);

        return processOutput();
    }

    private void preOrderTraversal(TreeNode root) {

        if (root == null) {
            return;
        }

        preOrderTraversal(root.left);

        processRoot(root);

        preOrderTraversal(root.right);
    }

    private void processRoot(TreeNode root) {

        if (currentValue == null || root.val != currentValue) {
            currentMode = 0;
        }

        currentMode++;

        if (currentMode > mode) {
            mode = currentMode;
            result.clear();
            result.add(root.val);
        } else if (currentMode == mode) {
            result.add(root.val);
        }

        currentValue = root.val;
    }

    private int[] processOutput() {

        int size = result.size();

        int[] output = new int[size];

        for (int i = 0; i < size; i++) {
            output[i] = result.get(i);
        }

        return output;
    }
}