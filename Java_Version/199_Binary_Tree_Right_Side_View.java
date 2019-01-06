/*
Given a binary tree,
imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

        Example:

        Input: [1,2,3,null,5,null,4]

        Output: [1, 3, 4]
        Explanation:

        1            <---
        /   \
        2     3         <---
        \     \
        5     4       <---*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// Method 1: Level Traverse
/*
class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                if (i == size - 1) {
                    result.add(currentNode.val);
                }
            }
        }

        return result;
    }
}*/

// Method 2: With depth
class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> result = new LinkedList<>();

        rightSideViewHelper(root, result, 0);

        return result;
    }

    private void rightSideViewHelper(
            TreeNode currentNode, List<Integer> result, int currentDepth) {

        if (currentNode == null) {
            return;
        }

        if (currentDepth == result.size()) {
            result.add(currentNode.val);
        }

        rightSideViewHelper(currentNode.right, result, currentDepth + 1);

        rightSideViewHelper(currentNode.left, result, currentDepth + 1);
    }
}
