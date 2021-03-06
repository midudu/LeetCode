/*
  Given a binary tree, return the post_order traversal of its nodes' values.

Example:

        Input: [1,null,2,3]

        1
         \
          2
         /
        3

        Output: [3,2,1]

Follow up:
  Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.LinkedList;
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

/* class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        postorderTraversalHelper(root);

        return this.result;
    }

    private void postorderTraversalHelper(TreeNode root) {

        if (root == null) {
            return;
        }

        postorderTraversalHelper(root.left);
        postorderTraversalHelper(root.right);

        this.result.add(root.val);
    }
} */


/*class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);
        root.left.left.right = new TreeNode(9);

        List<Integer> list = new Solution().postorderTraversal(root);

        System.out.println();
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode currentNode = stack.pop();
            result.addFirst(currentNode.val);

            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }

            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }

        return result;
    }
}*/

class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(11);
        root.left.left.right = new TreeNode(9);

        List<Integer> list = new Solution().postorderTraversal(root);

        System.out.println(list);
    }

    private static class TreeNodeWrapper{

        int count = 0;
        TreeNode node;

        TreeNodeWrapper(TreeNode node) {
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNodeWrapper> stack = new Stack<>();
        stack.push(new TreeNodeWrapper(root));

        while (!stack.isEmpty()) {

            TreeNodeWrapper wrapper = stack.pop();

            if (wrapper.node.left == null && wrapper.node.right == null) {
                result.add(wrapper.node.val);
            } else {
                if (wrapper.count != 0) {
                    result.add(wrapper.node.val);
                } else {
                    wrapper.count++;
                    stack.push(wrapper);

                    if (wrapper.node.right != null) {
                        stack.push(new TreeNodeWrapper(wrapper.node.right));
                    }
                    if (wrapper.node.left != null) {
                        stack.push(new TreeNodeWrapper(wrapper.node.left));
                    }
                }
            }
        }

        return result;
    }
}

