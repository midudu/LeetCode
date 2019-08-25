/*
  Given a binary tree, return all root-to-leaf paths.

  For example, given the following binary tree:

            1
          /   \
         2     3
          \
           5

  All root-to-leaf paths are:

  ["1->2->5", "1->3"]
*/

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = new Solution().binaryTreePaths(root);

        System.out.println();
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        binaryTreePathsHelper(root, new ArrayList<>(), result);
        return result;
    }

    private void binaryTreePathsHelper(
            TreeNode root, List<Integer> existingNumbers, List<String> result) {

        if (root == null) {
            return;
        }

        existingNumbers.add(root.val);

        if (root.left == null && root.right == null) {
            result.add(convertIntegerListToString(existingNumbers));
        }

        binaryTreePathsHelper(root.left, existingNumbers, result);
        binaryTreePathsHelper(root.right, existingNumbers, result);

        existingNumbers.remove(existingNumbers.size() - 1);
    }

    private String convertIntegerListToString(List<Integer> numbers) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numbers.size() - 1; i++) {

            result.append(numbers.get(i));
            result.append("->");
        }

        result.append(numbers.get(numbers.size() - 1));

        return result.toString();
    }
}
