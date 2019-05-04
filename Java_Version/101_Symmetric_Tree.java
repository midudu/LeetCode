/*
  Given a binary tree, check whether it is a mirror of itself (ie, symmetric
around its center).

  For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

        1
        / \
        2   2
        / \ / \
        3  4 4  3

  But the following [1,2,2,null,3,null,3] is not:
        1
        / \
        2   2
        \   \
        3    3

Note:
  Bonus points if you could solve it both recursively and iteratively.
*/

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// Method 1: Recursive method
/*
class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left, right.right)
                && isSymmetricHelper(left.right,right.left);
    }
}*/

// Method 2: Non-recursive method
class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (root.left == null || root.right == null) {
            return (root.left == root.right);
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {

            if ((stack.size() & 1) != 0) {
                return false;
            }

            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if (right.val != left.val) {
                return false;
            }

            if (left.left != null) {

                if (right.right == null) {
                    return false;
                }

                stack.push(left.left);
                stack.push(right.right);

            } else if (right.right != null) {
                return false;
            }

            if (left.right != null) {

                if (right.left == null) {
                    return false;
                }

                stack.push(left.right);
                stack.push(right.left);

            } else if (right.left != null) {
                return false;
            }
        }

        return true;
    }
}