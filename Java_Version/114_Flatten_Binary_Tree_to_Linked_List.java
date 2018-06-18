/* Given a binary tree, flatten it to a linked list in-place.

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
          6 */


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

        TreeNode leftLeaf = root.left;
        TreeNode rightLeaf = root.right;

        root.left = null;
        root.right = flattenHelper(leftLeaf);

        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }

        temp.right = flattenHelper(rightLeaf);

        return root;
    }
}