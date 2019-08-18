/*
  Given a binary search tree with non-negative values, find the minimum
absolute difference between values of any two nodes.

Example:

        Input:

          1
           \
           3
          /
         2

        Output:
        1

        Explanation:
          The minimum absolute difference is 1, which is the difference between
        2 and 1 (or between 2 and 3).

Note:
  There are at least two nodes in this BST.
*/

/*
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
*/

class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        System.out.println(new Solution().getMinimumDifference(root));
    }

    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        getMinimumDifferenceHelper(root);

        return this.result;
    }

    private Integer[] getMinimumDifferenceHelper(TreeNode root) {

        if (root.left == null && root.right == null) {
            return new Integer[]{root.val, root.val};
        }

        if (root.left == null) {
            Integer[] rightResult = getMinimumDifferenceHelper(root.right);
            this.result = Math.min(result, rightResult[0] - root.val);
            return new Integer[]{root.val, rightResult[1]};
        }

        if (root.right == null) {
            Integer[] leftResult = getMinimumDifferenceHelper(root.left);
            this.result = Math.min(result, root.val - leftResult[1]);
            return new Integer[]{leftResult[0], root.val};
        }

        Integer[] leftResult = getMinimumDifferenceHelper(root.left);
        Integer[] rightResult = getMinimumDifferenceHelper(root.right);
        this.result = Math.min(result, rightResult[0] - root.val);
        this.result = Math.min(result, root.val - leftResult[1]);

        return new Integer[]{leftResult[0], rightResult[1]};
    }
}
