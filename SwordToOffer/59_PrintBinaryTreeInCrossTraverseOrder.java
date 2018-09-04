/* 
题目描述

请实现一个函数按照之字形打印二叉树，

即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，
第三行按照从左到右的顺序打印，其他行以此类推。 */

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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
	
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		if ( pRoot == null ) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(pRoot);
		
		int currentRow = 1;
		while ( !queue.isEmpty() ) {
			
			int size = queue.size();
			ArrayList<Integer> currentRowResult = new ArrayList<>();
			
			for (int i = 0; i < size; i++ ) {
				TreeNode currentNode = queue.poll();
				
				if ( currentRow % 2 == 1 ) {
					currentRowResult.add(currentNode.val);
				} else {
					currentRowResult.add(0, currentNode.val);
				}
				
				if ( currentNode.left != null ) {
					queue.offer(currentNode.left);
				}
				if ( currentNode.right != null ) {
					queue.offer(currentNode.right);
				}
			}
			
			currentRow++;
			result.add(currentRowResult);
		}
		
		return result;
    }
}