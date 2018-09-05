/* 
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。 */

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
    
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		if ( pRoot == null ) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(pRoot);
		
		while ( !queue.isEmpty() ) {
			
			int size = queue.size();
			
			ArrayList<Integer> currentRow = new ArrayList<>();
			for ( int i = 0; i < size; i++ ) {
				
				TreeNode currentNode = queue.poll();
				currentRow.add(currentNode.val);
				
				if ( currentNode.left != null ) {
					queue.offer(currentNode.left);
				}
				
				if ( currentNode.right != null ) {
					queue.offer(currentNode.right);
				}
			}
			result.add(currentRow);
		}
		
		return result;
    }
    
}