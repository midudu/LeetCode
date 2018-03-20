/*Given a linked list, determine if it has a cycle in it.

        Follow up:
        Can you solve it without using extra space?*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        boolean result = new Solution().isSymmetric(root);

        System.out.println(result);
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


class MinStack {

    /**
     * initialize your data structure here.
     */
    private List<Integer> stack = new ArrayList<>();
    private List<Integer> minValue = new ArrayList<>();
    private int stackIndex = -1;
    private int minIndex = -1;


    public MinStack() {

    }

    public void push(int x) {
        if ( stackIndex == -1 ) {
            minValue.add(x);
            minIndex++;
        } else if (x <= minValue.get(minIndex)) {
            minValue.add(x);
            minIndex++;
        }

        stack.add(x);
        stackIndex++;
    }

    public void pop() {
        int temp = stack.get(stackIndex);
        if (minValue.get(minIndex) == temp) {
            minValue.remove(minIndex);
            minIndex--;
        }
        stack.remove(stackIndex);
        stackIndex--;
    }

    public int top() {
        return stack.get(stackIndex);
    }

    public int getMin() {
        return minValue.get(minIndex);
    }
}