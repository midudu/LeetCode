/*Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

        Please note that the string does not contain any non-printable characters.

        Example:

        Input: "Hello, my name is John"
        Output: 5*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        new Solution().countSegments("   f");

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
    public int countSegments(String s) {

        //method 1(slow method)
        /*String[] result = s.split("\\s+");
        if (result.length == 0) {
            return 0;
        } else {
            if (result[0].equals("")) {
                return result.length - 1;
            } else {
                return result.length;
            }
        }*/

        int result = 0;
        int sLength = s.length();

        int i = 0;
        while (i < sLength && s.charAt(i) == ' ') {
            i++;
        }
        
    }
}