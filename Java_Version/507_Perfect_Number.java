/*We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

        Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
        Example:
        Input: 28
        Output: True
        Explanation: 28 = 1 + 2 + 4 + 7 + 14
        Note: The input number n will not exceed 100,000,000. (1e8)*/

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

        new Solution().findRelativeRanks(new int[]{2, 4, 5, 1, 0});
    }
}


class Solution {
    public boolean checkPerfectNumber(int num) {

        if (num == 1) {
            return false;
        }

        int endNumber = (int) Math.sqrt(num);
        int result = 1;
        for (int i = 2; i <= endNumber; i++) {
            if (num % i == 0) {
                int anotherNum = num / i;
                if (anotherNum == i) {
                    result += anotherNum;
                } else {
                    result += anotherNum + i;
                }
            }
        }

        return result == num;
    }
}