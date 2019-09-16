/*
  The thief has found himself a new place for his thievery again. There is only
one entrance to this area, called the "root." Besides the root, each house has
one and only one parent house. After a tour, the smart thief realized that "all
houses in this place forms a binary tree". It will automatically contact the
police if two directly-linked houses were broken into on the same night.

  Determine the maximum amount of money the thief can rob tonight without
alerting the police.

Example 1:

        Input: [3,2,3,null,3,null,1]

             3
            / \
           2   3
            \   \
             3   1

        Output: 7

        Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

        Input: [3,4,5,1,3,null,1]

              3
             / \
            4   5
           / \   \
          1   3   1

        Output: 9

        Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
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
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(new Solution().rob(root));
    }

    public int rob(TreeNode root) {

        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robHelper(TreeNode root) {

        // int[0]: not rob current node, int[1] rob current node

        if (root == null) {
            return new int[2];
        }

        int[] leftResult = robHelper(root.left);
        int[] rightResult = robHelper(root.right);

        int[] currentResult = new int[2];
        currentResult[0] = Math.max(leftResult[0], leftResult[1])
                + Math.max(rightResult[0], rightResult[1]);
        currentResult[1] = root.val + leftResult[0] + rightResult[0];

        return currentResult;
    }
}
