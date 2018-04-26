/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an integer, write a function to determine if it is a power of two.*/


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
    public boolean isPowerOfTwo(int n) {

        if ( n <= 0 ) {
            return false;
        }

        int start = 0, end = 30;

        if (n > (1<<30)) {
            return false;
        }

        while (start <= end) {

            int mid = (start+end)/2;
            if ( n > (1<<mid) ) {
                start = mid + 1;
            } else if ( n < (1<<mid) ) {
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}