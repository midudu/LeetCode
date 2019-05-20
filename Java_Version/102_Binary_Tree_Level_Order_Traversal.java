/*
  Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).

For example:
  Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

  return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
*/

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


class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int currentSize = queue.size();

            List<Integer> currentList = new ArrayList<>(currentSize);

            for (int i = 0; i < currentSize; i++) {

                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                currentList.add(currentNode.val);
            }

            result.add(currentList);
        }

        return result;
    }
}