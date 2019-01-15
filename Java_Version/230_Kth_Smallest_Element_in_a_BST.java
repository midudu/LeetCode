/*
Given a binary search tree,
write a function kthSmallest to find the kth smallest element in it.

Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

        Input: root = [3,1,4,null,2], k = 1

         3
        / \
       1   4
        \
         2
        Output: 1

Example 2:

        Input: root = [5,3,6,2,4,null,null,1], k = 3

         5
        / \
       3   6
      / \
     2   4
     /
    1
        Output: 3

        Follow up:

        What if the BST is modified (insert/delete operations) often
        and you need to find the kth smallest frequently?

        How would you optimize the kthSmallest routine?*/

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int index = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {

        kthSmallestHelper(root, k);

        return result;
    }

    private void kthSmallestHelper(TreeNode root, int k) {

        if (index == k || root == null) {
            return;
        }

        kthSmallestHelper(root.left, k);

        index++;
        if (index == k) {
            result = root.val;
        }

        kthSmallestHelper(root.right, k);
    }
}
