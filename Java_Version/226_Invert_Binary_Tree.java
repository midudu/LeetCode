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
         9   6 3   1
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
