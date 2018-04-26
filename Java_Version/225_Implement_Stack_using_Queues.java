/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Implement the following operations of a stack using queues.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        empty() -- Return whether the stack is empty.
        Notes:
        You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
        Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
        You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).*/

import sun.plugin.javascript.navig.LinkArray;

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        ListNode result = new Solution().reverseList(root);

        //System.out.println(result);
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


class MyStack {

    /**
     * Initialize your data structure here.
     */
    private Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        int size = queue.size();
        queue.offer(x);

        for (int i = 0; i < size; i++) {

            Integer temp = queue.poll();
            queue.offer(temp);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

        return queue.isEmpty();
    }
}