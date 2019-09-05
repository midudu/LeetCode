/*
  Find the sum of all left leaves in a given binary tree.

  Example:

             3
            / \
           9  20
             /  \
            15   7

  There are two left leaves in the binary tree, with values 9 and 15
respectively. Return 24.
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
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().sumOfLeftLeaves(root));
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] result = new int[1];

        sumOfLeftLeavesHelper(root, result);

        return result[0];
    }

    private void sumOfLeftLeavesHelper(TreeNode root, int[] result) {

        if (root == null) {
            return;
        }

        if (root.left == null) {
            sumOfLeftLeavesHelper(root.right, result);
            return;
        }

        if (root.left.left == null && root.left.right == null) {
            result[0] += root.left.val;
        }

        sumOfLeftLeavesHelper(root.left, result);
        sumOfLeftLeavesHelper(root.right, result);
    }
}
