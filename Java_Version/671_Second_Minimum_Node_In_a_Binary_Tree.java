/*
  Given a non-empty special binary tree consisting of nodes with the
non-negative value, where each node in this tree has exactly two or zero
sub-node. If the node has two sub-nodes, then this node's value is the smaller
value among its two sub-nodes. More formally, the property root.val =
min(root.left.val, root.right.val) always holds.

  Given such a binary tree, you need to output the second minimum value in the
set made of all the nodes' value in the whole tree.

  If no such second minimum value exists, output -1 instead.

Example 1:

        Input:

            2
           / \
          2   5
         / \
        5   7

        Output: 5

        Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:

        Input:

           2
          / \
         2   2

        Output: -1

        Explanation: The smallest value is 2, but there isn't any second
      smallest value.
*/

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x; }
}


class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        System.out.println(new Solution().findSecondMinimumValue(root));
    }

    private int secondMinVal;

    public int findSecondMinimumValue(TreeNode root) {

        if (root == null || root.left == null) {
            return -1;
        }

        this.secondMinVal = -1;

        findSecondMinimumValueHelper(root);

        return this.secondMinVal;
    }

    private void findSecondMinimumValueHelper(TreeNode root) {

        if (root.left == null) {
            return;
        }

        if (secondMinVal != -1 && root.val >= secondMinVal) {
            return;
        }

        int leftVal = root.left.val;
        int rightVal = root.right.val;

        if (leftVal == rightVal) {
            findSecondMinimumValueHelper(root.left);
            findSecondMinimumValueHelper(root.right);
        } else {
            if (leftVal == root.val) {
                if (secondMinVal == -1) {
                    secondMinVal = rightVal;
                } else {
                    secondMinVal = Math.min(secondMinVal, rightVal);
                }
                findSecondMinimumValueHelper(root.left);
            } else {
                if (secondMinVal == -1) {
                    secondMinVal = leftVal;
                } else {
                    secondMinVal = Math.min(secondMinVal, leftVal);
                }
                findSecondMinimumValueHelper(root.right);
            }
        }
    }
}
