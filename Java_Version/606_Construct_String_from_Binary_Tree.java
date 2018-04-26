/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

        The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

        Example 1:
        Input: Binary tree: [1,2,3,4]
        1
        /   \
        2     3
        /
        4

        Output: "1(2(4))(3)"

        Explanation: Originallay it needs to be "1(2(4)())(3()())",
        but you need to omit all the unnecessary empty parenthesis pairs.
        And it will be "1(2(4))(3)".
        Example 2:
        Input: Binary tree: [1,2,3,null,4]
        1
        /   \
        2     3
        \
        4

        Output: "1(2()(4))(3)"

        Explanation: Almost the same as the first example,
        except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        int[] ints = {2, 6, 4, 8, 10, 9, 15};
        new Solution().findUnsortedSubarray(ints);

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
    StringBuilder result = new StringBuilder("");

    public String tree2str(TreeNode t) {

        if (t == null) {
            return result.toString();
        }

        tree2strHelper(t);
        return result.toString();
    }

    private void tree2strHelper(TreeNode t) {

        result.append(t.val);

        if (t.left == null && t.right == null) {
            return;
        } else if (t.left == null && t.right != null) {
            result.append("()");

            result.append("(");
            tree2strHelper(t.right);
            result.append(")");
        } else if (t.left != null && t.right == null) {
            result.append("(");
            tree2strHelper(t.left);
            result.append(")");
        } else {

            result.append("(");
            tree2strHelper(t.left);
            result.append(")");

            result.append("(");
            tree2strHelper(t.right);
            result.append(")");
        }
    }
}