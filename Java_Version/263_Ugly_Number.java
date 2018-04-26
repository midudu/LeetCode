/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Write a program to check whether a given number is an ugly number.

        Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

        Note:

        1 is typically treated as an ugly number.
        Input is within the 32-bit signed integer range.*/


import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test {
    public static void main(String[] args) {

        String s = "egg", t = "add";

        new Solution().isIsomorphic(s, t);
    }
}


class Solution {
    public boolean isUgly(int num) {

        if (num == 1) {
            return true;
        }
        if (num == 0) {
            return false;
        }

        while (num % 2 == 0) {
            num >>= 1;
        }

        while (num % 3 == 0) {
            num /= 3;
        }

        while (num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}