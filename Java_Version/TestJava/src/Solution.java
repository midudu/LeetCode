import java.util.Stack;

public class Solution {

    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {

        mainStack.push(node);

        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            if ( node <= minStack.peek() ) {
                minStack.push(node);
            }
        }
    }

    public void pop() {

        if (mainStack.isEmpty()) {
            return;
        }

        Integer topValue = mainStack.pop();
        if ( topValue.intValue() == minStack.peek() ) {
            minStack.pop();
        }
    }

    public int top() {

        return mainStack.pop();
    }

    public int min() {

        return minStack.peek();
    }
}