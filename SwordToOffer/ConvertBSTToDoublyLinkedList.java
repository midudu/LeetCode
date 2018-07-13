/* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。 */

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
    public TreeNode Convert(TreeNode pRootOfTree) {
        
        if ( pRootOfTree == null ) {
            return null;
        }
        
        return ConvertHelper(pRootOfTree);
    }
    
    private TreeNode ConvertHelper(TreeNode root) {
        
        if (root == null) {
            return null;
        }
        
        TreeNode leftHead = ConvertHelper(root.left);
        TreeNode rightHead = ConvertHelper(root.right);
        
        if (leftHead == null && rightHead == null) {
            return root;
        } else if ( leftHead != null && rightHead == null ) {
            
            TreeNode tempNode = leftHead;
            while ( tempNode.right != null ) {
                tempNode = tempNode.right;
            }
            
            tempNode.right = root;
            root.left = tempNode;
            return leftHead;
        } else if ( leftHead == null && rightHead != null) {
            
            root.right = rightHead;
            rightHead.left = root;
            return root;
        } else {
            TreeNode tempNode = leftHead;
            while ( tempNode.right != null ) {
                tempNode = tempNode.right;
            }
            
            tempNode.right = root;
            root.left = tempNode;
            
            root.right = rightHead;
            rightHead.left = root;
            return leftHead;
        }
    } 
}