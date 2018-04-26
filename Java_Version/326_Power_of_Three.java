/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given an integer, write a function to determine if it is a power of three.

        Follow up:
        Could you do it without using any loop / recursion?*/

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
    public boolean isPowerOfThree(int n) {

        if (n <= 0) {
            return false;
        }

        double value = Math.log(Integer.MAX_VALUE)/Math.log(3);

        int maxPowerOfThree = (int)Math.round(
                Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3)) )
        );

        return (maxPowerOfThree%n == 0);
    }
}