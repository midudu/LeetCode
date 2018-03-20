/*We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

        Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

        Example 1:
        Input:
        bits = [1, 0, 0]
        Output: True
        Explanation:
        The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
        Example 2:
        Input:
        bits = [1, 1, 1, 0]
        Output: False
        Explanation:
        The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
        Note:

        1 <= len(bits) <= 1000.
        bits[i] is always 0 or 1.*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {

        int a = 3, b = 0;


        int result = a / b;


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
    public boolean isOneBitCharacter(int[] bits) {

        if (bits == null || bits.length < 2) {
            return true;
        }

        int bitsLength = bits.length;

        if (bits[bitsLength - 2] == 0) {
            return true;
        }

        int onesCount = 0;

        for (int i = bitsLength - 3; i >= 0; i--) {

            if (bits[i] == 1) {
                onesCount++;
            } else {
                break;
            }
        }

        return (onesCount % 2 == 1);
    }
}