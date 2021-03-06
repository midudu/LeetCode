/*
  Given a binary tree, return the preorder traversal of its nodes' values.

        Example:

        Input: [1,null,2,3]

           1
            \
             2
            /
           3

        Output: [1,2,3]

Follow up:
  Recursive solution is trivial, could you do it iteratively?
*/

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/* class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        preorderTraversalHelper(root);

        return this.result;
    }

    private void preorderTraversalHelper(TreeNode root) {

        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversalHelper(root.left);
        preorderTraversalHelper(root.right);
    }
} */


class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

	    List<Integer> result = new ArrayList<>();
	
        if (root == null) {
			return result;
		}
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			
			TreeNode currentNode = stack.pop();
			result.add(currentNode.val);
			
			if (currentNode.right != null) {
				stack.push(currentNode.right);
			}
			
			if (currentNode.left != null) {
				stack.push(currentNode.left);
			}
		}
		
		return result;
    }
}