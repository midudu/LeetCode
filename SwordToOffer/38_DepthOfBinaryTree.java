/* 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。 */

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public int TreeDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        return 1 + TreeDepthHelper(root);
    }
    
    private int TreeDepthHelper(TreeNode root) {
        
        if ( root.left == null && root.right == null ) {
            return 0;
        } else if (root.left == null && root.right != null) {
            return 1 + TreeDepthHelper(root.right);
        } else if (root.left != null && root.right == null) {
            return 1 + TreeDepthHelper(root.left);
        } else {
            return 1 + Math.max(TreeDepthHelper(root.left), TreeDepthHelper(root.right));
        }
    }
}