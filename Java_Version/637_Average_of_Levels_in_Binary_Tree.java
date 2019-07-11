/*
  Given a non-empty binary tree, return the average value of the nodes on each
level in the form of an array.

Example 1:

        Input:

               3
              / \
             9  20
           /  \
          15   7

        Output: [3, 14.5, 11]

Explanation:

  The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level
2 is 11. Hence return [3, 14.5, 11].

Note:
  The range of node's value is in the range of 32-bit signed integer.
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

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);

        List<Double> result = new Solution().averageOfLevels(root);

        System.out.println(result.toString());
    }

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                sum += currentNode.val;
            }

            result.add(sum / size);
        }

        return result;
    }
}