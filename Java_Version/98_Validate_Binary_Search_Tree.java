/*
Given a binary tree, determine if it is a valid binary search tree (BST).

        Assume a BST is defined as follows:

        The left subtree of a node contains only nodes with keys less than the node's key.
        The right subtree of a node contains only nodes with keys greater than the node's key.
        Both the left and right subtrees must also be binary search trees.
        Example 1:

        Input:
        2
        / \
        1   3
        Output: true
        Example 2:

        5
        / \
        1   4
        / \
        3   6
        Output: false
        Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
        is 5 but its right child's value is 4.*/

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public boolean isValidBST(TreeNode root) {

        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode root, Integer minValue, Integer maxValue) {

        if (root == null) {
            return true;
        }

        if (minValue != null && root.val <= minValue) {
            return false;
        }

        if (maxValue != null && root.val >= maxValue) {
            return false;
        }

        return isValidBSTHelper(root.left, minValue, root.val)
                && isValidBSTHelper(root.right, root.val, maxValue);
    }


}