/*You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

        Given n, find the total number of full staircase rows that can be formed.

        n is a non-negative integer and fits within the range of a 32-bit signed integer.

        Example 1:

        n = 5

        The coins can form the following rows:
        ¤
        ¤ ¤
        ¤ ¤

        Because the 3rd row is incomplete, we return 2.
        Example 2:

        n = 8

        The coins can form the following rows:
        ¤
        ¤ ¤
        ¤ ¤ ¤
        ¤ ¤

        Because the 4th row is incomplete, we return 3.*/


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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

        int input = 1804289383;

        new Solution().arrangeCoins(input);
    }
}


class Solution {
    public int arrangeCoins(int n) {

        int startPointer = 0;
        int endPoiner = (int) Math.exp((Math.log(2) + Math.log(Integer.MAX_VALUE)) / 2);

        while (startPointer < endPoiner) {
            int midPointer = (startPointer + endPoiner) / 2;
            int result = (int) (midPointer / 2.0 * (midPointer + 1));
            if (result < n) {
                startPointer = midPointer + 1;
            } else if (result == n) {
                return midPointer;
            } else {
                endPoiner = midPointer - 1;
            }
        }

        if ((int) (startPointer / 2.0 * (startPointer + 1)) > n) {
            return startPointer - 1;
        } else {
            return startPointer;
        }
    }
}