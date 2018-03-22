/*Implement the following operations of a queue using stacks.

        push(x) -- Push element x to the back of queue.
        pop() -- Removes the element from in front of queue.
        peek() -- Get the front element.
        empty() -- Return whether the queue is empty.
        Notes:
        You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
        Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
        You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).*/

import sun.plugin.javascript.navig.LinkArray;

import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        ListNode root = new ListNode(1);
        root.next = new ListNode(2);

        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);

        int value = myQueue.peek();

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


class MyQueue {

    /**
     * Initialize your data structure here.
     */
    Stack<Integer> mainStack, helperStack;

    public MyQueue() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (mainStack.empty()) {
            mainStack.push(x);
        } else {

            while (!mainStack.empty()) {
                helperStack.push(mainStack.pop());
            }
            mainStack.push(x);
            while (!helperStack.empty()){
                mainStack.push(helperStack.pop());
            }
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return mainStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return mainStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return mainStack.empty();
    }
}