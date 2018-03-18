/*Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

        Example 1:
        Input: "Let's take LeetCode contest"
        Output: "s'teL ekat edoCteeL tsetnoc"
        Note: In the string, each word is separated by single space and there will not be any extra space in the string.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException{

        int a = 3, b = 0;


        int result = a/b;


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
    public String reverseWords(String s) {

        String[] splitS = s.split("\\s");

        int splitSLength = splitS.length;
        if (splitSLength < 1){
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0 ; i < splitSLength - 1; i++){
            result = result.append(new StringBuilder(splitS[i]).reverse()).append(' ');
        }

        return result.append(new StringBuilder(splitS[splitSLength-1]).reverse()).toString();
    }
}