/*Given a positive integer num, write a function which returns True if num is a perfect square else False.

        Note: Do not use any built-in library function such as sqrt.

        Example 1:

        Input: 16
        Returns: True
        Example 2:

        Input: 14
        Returns: False*/


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
    public boolean isPerfectSquare(int num) {

        int startPointer = 1, endPointer = num;

        while (startPointer <= endPointer) {

            int midPointer = startPointer + (endPointer - startPointer) / 2;

            if (num / midPointer == midPointer) {
                int temp = midPointer * midPointer;
                if (temp == num) {
                    return true;
                } else if (temp < num) {
                    startPointer = midPointer + 1;
                } else {
                    endPointer = midPointer - 1;
                }
            } else if (num / midPointer > midPointer) {
                startPointer = midPointer + 1;
            } else if (num / midPointer < midPointer) {
                endPointer = midPointer - 1;
            }
        }

        return false;
    }
}