/*
  Given two binary trees and imagine that when you put one of them to cover the
other, some nodes of the two trees are overlapped while the others are not.

  You need to merge them into a new binary tree. The merge rule is that if two
nodes overlap, then sum node values up as the new value of the merged node.
Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

        Input:

        Tree 1                     Tree 2

             1                         2
            / \                       / \
           3   2                     1   3
          /                           \   \
         5                             4   7

        Output:

        Merged tree:

            3
           / \
          4   5
         / \   \
        5   4   7

Note:
  The merging process must start from the root nodes of both trees.
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

        TreeNode left = new TreeNode(1);
        left.left = new TreeNode(3);
        left.right = new TreeNode(2);
        left.left.left = new TreeNode(5);

        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(1);
        right.right = new TreeNode(3);
        right.left.right = new TreeNode(4);
        right.right.right = new TreeNode(7);

        TreeNode result = new Solution().mergeTrees(left, right);

        System.out.println();
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null || t2 == null) {
            if (t1 == null && t2 == null) {
                return null;
            } else {
                return (t1 == null ? t2 : t1);
            }
        }

        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);

        return root;
    }

}