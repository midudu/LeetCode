/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given two binary strings, return their sum (also a binary string).

        For example,
        a = "11"
        b = "1"
        Return "100".*/


import java.util.*;
import java.lang.Math;
import java.lang.System;
import java.lang.Integer;


public class Main {

    public static void main(String[] args) throws ArithmeticException {


        Solution solution = new Solution();
        String result = solution.addBinary("0", "0");

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
    public String addBinary(String a, String b) {

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int pointerAChars = aChars.length - 1;
        int pointerBChars = bChars.length - 1;
        char[] resultChar = new char[Math.max(pointerAChars + 1, pointerBChars + 1)];
        int pointerResult = resultChar.length - 1;

        int additionBit = 0;
        while (pointerAChars >= 0 || pointerBChars >= 0) {
            int bitOne = pointerAChars >= 0 ? aChars[pointerAChars] - '0' : 0;
            int bitTwo = pointerBChars >= 0 ? bChars[pointerBChars] - '0' : 0;
            int result = bitOne + bitTwo + additionBit;
            resultChar[pointerResult] = result == 0 || result == 2 ? '0' : '1';
            additionBit = result / 2;

            pointerAChars--;
            pointerBChars--;
            pointerResult--;
        }

        if (additionBit == 1) {
            return "1" + new String(resultChar);
        } else
            return new String(resultChar);


    }
}