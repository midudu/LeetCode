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

// Method 2: Non-Recursive version
class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        System.out.println(new Solution().inorderTraversal(root).toString());
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (!stack.isEmpty() || currentNode != null) {

            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            TreeNode mostLeftNode = stack.pop();
            result.add(mostLeftNode.val);

            currentNode = mostLeftNode.right;
        }

        return result;
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

