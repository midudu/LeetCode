/* 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        return reConstructBinaryTreeHelper(
                pre, 0,
                in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTreeHelper(
            int[] pre, int preStartIndex,
            int[] in, int inStartIndex, int inEndIndex) {

        if (inStartIndex > inEndIndex) {
            return null;
        }

        TreeNode rootNode = new TreeNode(pre[preStartIndex]);
        int rootIndexOfIn = findRootIndexOfIn(
                pre[preStartIndex], in, inStartIndex, inEndIndex);

        rootNode.left = reConstructBinaryTreeHelper(pre, preStartIndex + 1,
                in, inStartIndex, rootIndexOfIn - 1);

        rootNode.right = reConstructBinaryTreeHelper(pre, rootIndexOfIn - inStartIndex + preStartIndex + 1,
                in, rootIndexOfIn + 1, inEndIndex);

        return rootNode;
    }

    private int findRootIndexOfIn(int rootValue, int[] in, int inStartIndex, int inEndIndex) {

        for (int i = inStartIndex; i <= inEndIndex; i++) {
            if (in[i] == rootValue) {
                return i;
            }
        }

        return -1;
    }
}