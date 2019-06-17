/*
  Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
  You may assume that duplicates do not exist in the tree.

For example, given

  preorder = [3,9,20,15,7]
  inorder = [9,3,15,20,7]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
*/


import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null) {
            return null;
        }

        if (preorder.length != inorder.length) {
            throw new RuntimeException("wrong input");
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1,
                0);
    }

    private TreeNode buildTreeHelper(
            int[] preOrder, int preStartIndex, int preEndIndex,
            int inStartIndex) {

        if (preStartIndex > preEndIndex) {
            return null;
        } else if (preStartIndex == preEndIndex) {
            return new TreeNode(preOrder[preStartIndex]);
        }

        TreeNode root = new TreeNode(preOrder[preStartIndex]);

        int rootIndexInOrder = this.map.get(root.val);
        int length = rootIndexInOrder - inStartIndex;

        root.left = buildTreeHelper(preOrder, preStartIndex + 1, preStartIndex + length, inStartIndex);
        root.right = buildTreeHelper(preOrder, preStartIndex + length + 1, preEndIndex,
                rootIndexInOrder + 1);

        return root;
    }
}