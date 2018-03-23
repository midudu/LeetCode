/*Given an array of characters, compress it in-place.

        The length after compression must always be smaller than or equal to the original array.

        Every element of the array should be a character (not int) of length 1.

        After you are done modifying the input array in-place, return the new length of the array.


        Follow up:
        Could you solve it using only O(1) extra space?


        Example 1:
        Input:
        ["a","a","b","b","c","c","c"]

        Output:
        Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

        Explanation:
        "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
        Example 2:
        Input:
        ["a"]

        Output:
        Return 1, and the first 1 characters of the input array should be: ["a"]

        Explanation:
        Nothing is replaced.
        Example 3:
        Input:
        ["a","b","b","b","b","b","b","b","b","b","b","b","b"]

        Output:
        Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

        Explanation:
        Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
        Notice each digit has it's own entry in the array.
        Note:
        All characters have an ASCII value in [35, 126].
        1 <= len(chars) <= 1000.*/


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
    public int compress(char[] chars) {

        if (chars == null || chars.length == 0) {
            return 0;
        }

        int charsLength = chars.length;

        char currentChar = chars[0];
        int slowPointer = 0;
        int currentCount = 0;

        for (int i = 0; i < charsLength; i++) {

            if (chars[i] == currentChar) {
                currentCount++;

            } else {

                chars[slowPointer] = currentChar;
                slowPointer++;

                if (currentCount > 1) {

                    String currentString = Integer.toString(currentCount);
                    for (int j = 0; j < currentString.length(); j++) {
                        chars[slowPointer] = currentString.charAt(j);
                        slowPointer++;
                    }
                }

                currentChar = chars[i];
                currentCount = 1;
            }
        }

        chars[slowPointer] = currentChar;
        slowPointer++;

        if (currentCount > 1) {

            String currentString = Integer.toString(currentCount);
            for (int j = 0; j < currentString.length(); j++) {
                chars[slowPointer] = currentString.charAt(j);
                slowPointer++;
            }
        }

        return slowPointer;

    }
}