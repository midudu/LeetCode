/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

        For example:

        Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

        Follow up:
        Could you do it without any loop/recursion in O(1) runtime?*/


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
    public int addDigits(int num) {

        return num == 0 ? 0 : (num % 9 == 0 ? 9 : (num % 9));
    }
}