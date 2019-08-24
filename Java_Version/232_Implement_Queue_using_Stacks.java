/*
  Implement the following operations of a queue using stacks.

        push(x) -- Push element x to the back of queue.
        pop() -- Removes the element from in front of queue.
        peek() -- Get the front element.
        empty() -- Return whether the queue is empty.

Notes:
  You must use only standard operations of a stack -- which means only push to
top, peek/pop from top, size, and is empty operations are valid. Depending on
your language, stack may not be supported natively. You may simulate a stack by
using a list or deque (double-ended queue), as long as you use only standard
operations of a stack.
   You may assume that all operations are valid (for example, no pop or peek
operations will be called on an empty queue).
*/

import java.util.Stack;

class MyQueue {

    /**
     * Initialize your data structure here.
     */
    private Stack<Integer> pushStack = new Stack<>(), popStack = new Stack<>();

    public MyQueue() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {

        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        if (!popStack.isEmpty()) {
            return popStack.pop();
        }

        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }

        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {

        if (!popStack.isEmpty()) {
            return popStack.peek();
        }

        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }

        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
