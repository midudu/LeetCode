/*
  Given a Binary Search Tree and a target number, return true if there exist
two elements in the BST such that their sum is equal to the given target.

Example 1:

        Input:

             5
            / \
           3   6
          / \   \
         2   4   7

        Target = 9

        Output: True

Example 2:

           Input:

             5
            / \
           3   6
          / \   \
         2   4   7

        Target = 28

        Output: False
*/


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

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(new Solution().findTarget(root, 4));
    }

    public boolean findTarget(TreeNode root, int k) {

        return findTargetHelper(root, root, k);
    }

    private boolean findTargetHelper(TreeNode root, TreeNode currentNode, int k) {

        if (currentNode == null) {
            return false;
        }

        return search(root.left, currentNode, k - currentNode.val)
                || search(root.right, currentNode, k - currentNode.val)
                || findTargetHelper(root, currentNode.left, k)
                || findTargetHelper(root, currentNode.right, k);
    }

    private boolean search(TreeNode root, TreeNode currentNode, int value) {

        if (root == null) {
            return false;
        }

        return (root.val == value) && (root != currentNode)
                || (root.val < value) && search(root.right, currentNode, value)
                || (root.val > value) && search(root.left, currentNode, value);
    }
}
