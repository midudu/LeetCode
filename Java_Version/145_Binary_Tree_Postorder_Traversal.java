/*
Given a binary tree, return the postorder traversal of its nodes' values.

        Example:

        Input: [1,null,2,3]
        1
        \
        2
        /
        3

        Output: [3,2,1]
        Follow up: Recursive solution is trivial, could you do it iteratively?*/

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

    public List<Integer> postorderTraversal(TreeNode root) {

        postorderTraversalHelper(root);

        return this.result;
    }

    private void postorderTraversalHelper(TreeNode root) {

        if (root == null) {
            return;
        }

        postorderTraversalHelper(root.left);
        postorderTraversalHelper(root.right);

        this.result.add(root.val);
    }
} */

class Solution {
	
	public List<Integer> postorderTraversal(TreeNode root) {
		
        LinkedList<Integer> res = new LinkedList<>();
		
        if(root == null){
            return res;
        }
		
		Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
		
        while (!stack.isEmpty()) {

            TreeNode curr = stack.pop();
            res.addFirst(curr.val);
			
            if(curr.left != null){
                stack.push(curr.left);   
            }
            if(curr.right != null){
                stack.push(curr.right);
            }
        }
		
        return res;
    }
}