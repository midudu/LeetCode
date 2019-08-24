/*
  Given a binary search tree, write a function kthSmallest to find the kth
smallest element in it.

Note:
  You may assume k is always valid, 1 ≤ k ≤ BST's total elements.


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

        How would you optimize the kthSmallest routine?
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

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        System.out.println(new Solution().kthSmallest(root, 3));
    }

    private Integer result = null;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {

        preOrder(root, k);

        return result;
    }

    private void preOrder(TreeNode root, int k) {

        if (result != null) {
            return;
        }

        if (root == null) {
            return;
        }

        preOrder(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        preOrder(root.right, k);
    }
}
