/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an integer n, return the number of trailing zeroes in n!.

        Note: Your solution should be in logarithmic time complexity.*/


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

        int num = 1808548329;

        new Solution().trailingZeroes(num);
    }
}


class Solution {
    public int trailingZeroes(int n) {

        if (n == 0) {
            return 0;
        }
        return (n / 5) + trailingZeroes(n / 5);
    }
}