/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Write an algorithm to determine if a number is "happy".

        A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

        Example: 19 is a happy number

        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1*/


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

        int num = 2147483648;

        new Solution().reverseBits(num);
    }
}


class Solution {
    private HashSet<Integer> hashSet = new HashSet<>();

    public boolean isHappy(int n) {

        if (hashSet.contains(n)) {
            return false;
        }

        hashSet.add(n);
        int sum = 0;
        while (n != 0) {
            int temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        if (sum == 1) {
            return true;
        } else {
            return isHappy(sum);
        }
    }
}