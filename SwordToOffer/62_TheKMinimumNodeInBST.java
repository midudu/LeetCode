/* 
题目描述

给定一棵二叉搜索树，请找出其中的第k小的结点。

例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。 */

/*
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
	
	private int currentIndex = 0;
	private TreeNode resultNode = null;
    
	TreeNode KthNode(TreeNode pRoot, int k) {
        
		if (pRoot == null) {
			return null;
		}
		
		KthNodeHelper(pRoot, k);
		
		return resultNode;
    }
	
	void KthNodeHelper(TreeNode pRoot, int k) {
		
		if ( resultNode != null ) {
			return;
		}
		
		if ( pRoot.left != null ) {
			KthNodeHelper(pRoot.left, k);
		}
		
		currentIndex++;
		if ( currentIndex == k) {
			resultNode = pRoot;
			return;
		}
		
		if ( pRoot.right != null ) {
			KthNodeHelper(pRoot.right, k);
		}
	}
}