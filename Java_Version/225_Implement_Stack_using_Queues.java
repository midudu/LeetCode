/*
  Implement the following operations of a stack using queues.

        push(x) -- Push element x onto stack.
        pop() -- Removes the element on top of the stack.
        top() -- Get the top element.
        empty() -- Return whether the stack is empty.
        Notes:
        You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
        Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
        You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).*/

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    /**
     * Initialize your data structure here.
     */
    private Queue<Integer> queue = new LinkedList<>();
    private int top = -1;

    public MyStack() {
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        queue.offer(x);
        top = x;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        if (queue.isEmpty()) {
            throw new RuntimeException("empty stack");
        }

        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            push(queue.poll());
        }

        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {

        return queue.isEmpty();
    }
}
