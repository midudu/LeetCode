/* 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。 */

import java.util.Stack;

public class Solution {
    Stack<Integer> mainStack = new Stack<Integer>();
    Stack<Integer> auxiliaryStack = new Stack<Integer>();
    
    public void push(int node) {
        
        if (mainStack.empty()) {
            mainStack.push(node);
        } else {
            while (!mainStack.empty()) {
                Integer topValue = mainStack.pop();
                auxiliaryStack.push(topValue);
            }
            mainStack.push(node);
            while (!auxiliaryStack.empty()) {
                Integer topValue = auxiliaryStack.pop();
                mainStack.push(topValue);
            }
        }
    }
    
    public int pop() {
        return mainStack.pop();
    }
}