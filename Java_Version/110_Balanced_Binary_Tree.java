/*
  Given a binary tree, determine if it is height-balanced.

  For this problem, a height-balanced binary tree is defined as:
    a binary tree in which the depth of the two subtrees of every node never
  differ by more than 1.


Example 1:

        Given the following tree [3,9,20,null,null,15,7]:

             3
            / \
           9  20
          /    \
        15      7

        Return true.

Example 2:

        Given the following tree [1,2,2,3,3,null,null,4,4]:

             1
            / \
           2   2
          / \
         3   3
        / \
       4   4

        Return false.
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

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int[] result = isBalancedHelper(root);

        return result[0] == 1;
    }

    private int[] isBalancedHelper(TreeNode root) {

        if (root == null) {
            return new int[]{1, 0};
        }

        int[] leftResult = isBalancedHelper(root.left);
        if (leftResult[0] != 1) {
            return new int[]{0, -1};
        }

        int[] rightResult = isBalancedHelper(root.right);
        if (rightResult[0] != 1) {
            return new int[]{0, -1};
        }

        if (Math.abs(leftResult[1] - rightResult[1]) > 1) {
            return new int[]{0, -1};
        }

        return new int[]{1, Math.max(leftResult[1], rightResult[1]) + 1};
    }
}
