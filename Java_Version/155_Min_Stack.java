/*
  Design a stack that supports push, pop, top, and retrieving the minimum
element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:

    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> Returns -3.
    minStack.pop();
    minStack.top();      --> Returns 0.
    minStack.getMin();   --> Returns -2.
*/

import java.util.*;
import java.lang.Integer;


class MinStack {

    /**
     * initialize your data structure here.
     */
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> minStack = new LinkedList<>();

    public MinStack() {
    }

    public void push(int x) {

        if ( minStack.isEmpty()) {
            minStack.addLast(x);
        } else if (x <= minStack.getLast()) {
            minStack.addLast(x);
        }

        stack.addLast(x);
    }

    public void pop() {

        if (minStack.getLast().equals(stack.getLast())) {
            minStack.removeLast();
        }
        stack.removeLast();
    }

    public int top() {

        return stack.getLast();
    }

    public int getMin() {

        return minStack.getLast();
    }
}
