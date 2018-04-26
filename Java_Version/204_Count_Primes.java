/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Description:

        Count the number of prime numbers less than a non-negative number, n.*/


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

        int input = 1;

        new Solution().reverseBits(input);
    }
}


class Solution {
    public int countPrimes(int n) {

        int result = 0;
        boolean storage[] = new boolean[n];

        for (int i = 2; i < n; i++) {

            if (storage[i]) {
                continue;
            }

            result++;
            for (int j = i + i; j < n; j += i) {
                storage[j] = true;
            }
        }

        return result;
    }
}