/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

        Example:
        Given num = 16, return true. Given num = 5, return false.

        Follow up: Could you solve it without loops/recursion?*/

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

        new Solution().isPowerOfThree(27);
    }
}


class Solution {
    public boolean isPowerOfFour(int num) {

        if (num <= 0) {
            return false;
        }

        int mask = 0x55555555;
        if ((num & mask) != 0) {
            return false;
        }

        return ((num & (num - 1)) == 0);
    }
}