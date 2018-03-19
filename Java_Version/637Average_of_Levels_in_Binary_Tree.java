/*Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
        Example 1:
        Input:
        3
        / \
        9  20
        /  \
        15   7
        Output: [3, 14.5, 11]
        Explanation:
        The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
        Note:
        The range of node's value is in the range of 32-bit signed integer.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        int a = 3, b = 0;


        int result = a / b;


        System.out.println("haha");
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;

            for (int i = 0; i < size; i++) {
                TreeNode tempNode = queue.poll();
                sum += tempNode.val;
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                    queue.add()
                }
            }

            result.add(sum/size);
        }

        return result;
    }
}