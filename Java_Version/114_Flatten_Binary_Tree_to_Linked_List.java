/*
  Given a binary tree, flatten it to a linked list in-place.

  For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

  The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
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

    public void flatten(TreeNode root) {

        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        root.left = null;
        root.right = flattenHelper(leftNode);

        TreeNode pointer = root;
        while (pointer.right != null) {
            pointer = pointer.right;
        }

        pointer.right = flattenHelper(rightNode);

        return root;
    }
}