/* Given preorder and inorder traversal of a tree, construct the binary tree.

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
   15   7 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {
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


    public static void main(String[] args) {

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = new Solution().reConstructBinaryTree(pre, in);
    }
}