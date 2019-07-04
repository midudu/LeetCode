/*
  Given a binary search tree and the lowest and highest boundaries as L and R,
trim the tree so that all its elements lies in [L, R] (R >= L). You might need
to change the root of the tree, so the result should return the new root of the
trimmed binary search tree.

Example 1:

        Input:

            1
           / \
          0   2

        L = 1
        R = 2

        Output:

           1
            \
             2

Example 2:

        Input:

             3
            / \
           0   4
            \
             2
            /
           1

        L = 1
        R = 3

        Output:

            3
           /
          2
         /
        1
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

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        TreeNode newRoot = new Solution().trimBST(root, 1, 3);

        System.out.println();
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) {
            return null;
        }

        return trimBSTHelper(root, L, R);
    }

    private TreeNode trimBSTHelper(TreeNode root, int L, int R) {

        if (root == null) {
            return null;
        }

        if (root.val < L) {
            return trimBSTHelper(root.right, L, R);
        } else if (root.val > R) {
            return trimBSTHelper(root.left, L, R);
        } else {
            root.left = trimBSTHelper(root.left, L, R);
            root.right = trimBSTHelper(root.right, L, R);
            return root;
        }
    }
}