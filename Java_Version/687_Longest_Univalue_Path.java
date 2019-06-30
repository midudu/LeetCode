/*
  Given a binary tree, find the length of the longest path where each node in
the path has the same value. This path may or may not pass through the root.

  The length of path between two nodes is represented by the number of edges
between them.

Example 1:

        Input:

             5
            / \
           4   5
          / \   \
         1   1   5

        Output: 2

Example 2:

        Input:

             1
            / \
           4   5
          / \   \
         4   4   5

        Output: 2

Note:

  The given binary tree has not more than 10000 nodes. The height of the tree
is not more than 1000.

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
        root.left = new TreeNode(1);

        System.out.println(new Solution().longestUnivaluePath(root));
    }

    private int result = 0;

    public int longestUnivaluePath(TreeNode root) {

        getLengthAndUpdateResult(root);

        return result;
    }

    private int getLengthAndUpdateResult(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int length1 = getLengthAndUpdateResult(root.left);
        int length2 = getLengthAndUpdateResult(root.right);

        if (root.left == null || root.left.val != root.val) {
            length1 = 0;
        } else {
            length1 += 1;
        }

        if (root.right == null || root.right.val != root.val) {
            length2 = 0;
        } else {
            length2 += 1;
        }

        this.result = Math.max(length1 + length2, this.result);

        return Math.max(length1, length2);
    }

}