/*
  Given a binary tree, return the inorder traversal of its nodes' values.

        Example:

        Input: [1,null,2,3]
        1
        \
        2
        /
        3

        Output: [1,3,2]

  Follow up: Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


/* Method 1: Recursive version
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        inorderTraversalHelper(root, result);

        return result;
    }

    private void inorderTraversalHelper(TreeNode root, List<Integer> result) {

        if (root.left != null) {
            inorderTraversalHelper(root.left, result);
        }

        result.add(root.val);

        if (root.right != null) {
            inorderTraversalHelper(root.right, result);
        }
    }
}*/

// Method 2: Non-Recursive version
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {

            if (currentNode != null) {
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }
            }

            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }

        return result;
    }
}