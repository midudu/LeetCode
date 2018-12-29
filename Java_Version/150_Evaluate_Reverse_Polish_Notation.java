/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, /. Each operand may be an integer or another expression.

        Note:

        Division between two integers should truncate toward zero.
        The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
        Example 1:

        Input: ["2", "1", "+", "3", "*"]
        Output: 9
        Explanation: ((2 + 1) * 3) = 9
        Example 2:

        Input: ["4", "13", "5", "/", "+"]
        Output: 6
        Explanation: (4 + (13 / 5)) = 6
        Example 3:

        Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
        Output: 22
        Explanation:
        ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        = ((10 * (6 / (12 * -11))) + 17) + 5
        = ((10 * (6 / -132)) + 17) + 5
        = ((10 * 0) + 17) + 5
        = (0 + 17) + 5
        = 17 + 5
        = 22
        */

import java.util.HashSet;
import java.util.Stack;

class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        HashSet<String> symbols = new HashSet<>();
        symbols.add("+");
        symbols.add("-");
        symbols.add("*");
        symbols.add("/");

        for (int i = 0; i < tokens.length; i++) {

            if (symbols.contains(tokens[i])) {

                Integer op2 = stack.pop();
                Integer op1 = stack.pop();

                if (tokens[i].equals("+")) {
                    stack.push(op1 + op2);
                } else if (tokens[i].equals("-")) {
                    stack.push(op1 - op2);
                } else if (tokens[i].equals("*")) {
                    stack.push(op1 * op2);
                } else {
                    stack.push(op1 / op2);
                }

            } else {

                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.pop();
    }
}
