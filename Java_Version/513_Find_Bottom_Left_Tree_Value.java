/*
  Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:

        Input:

           2
          / \
         1   3

        Output:
        1

Example 2:

        Input:

              1
             / \
            2   3
           /   / \
          4   5   6
         /
        7

        Output:
        7

Note:
  You may assume the tree (i.e., the given root node) is not NULL.
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

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new Solution().findBottomLeftValue(root));
    }

    private int maxLayer = 0;
    private int result = 0;

    public int findBottomLeftValue(TreeNode root) {

        if (root == null) {
            throw new RuntimeException("illegal input");
        }

        findBottomLeftValueHelper(root, 1);

        return result;
    }

    private void findBottomLeftValueHelper(TreeNode root, int currentLayer) {

        if (root.left == null && root.right == null) {
            if (currentLayer > this.maxLayer) {
                this.maxLayer = currentLayer;
                this.result = root.val;
            }
        } else if (root.left == null) {
            findBottomLeftValueHelper(root.right, currentLayer + 1);
        } else if (root.right == null) {
            findBottomLeftValueHelper(root.left, currentLayer + 1);
        } else {
            findBottomLeftValueHelper(root.left, currentLayer + 1);
            findBottomLeftValueHelper(root.right, currentLayer + 1);
        }
    }
}
