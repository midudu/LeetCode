/*Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

        Note:
        n is positive and will fit within the range of a 32-bit signed integer (n < 231).

        Example 1:

        Input:
        3

        Output:
        3
        Example 2:

        Input:
        11

        Output:
        0

        Explanation:
        The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.*/

import javax.print.DocFlavor;
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

        int input = 999999999;

        new Solution().findNthDigit(input);
    }
}


class Solution {

    public int findNthDigit(int n) {

        int bitsOfCurrent = 1;
        int currentCountOfNumbers = 9;
        int currentTotalBits = bitsOfCurrent * currentCountOfNumbers;
        int nCopy = n;
        int currentBaseNumber = 0;

        while (true) {

            if (nCopy <= currentTotalBits) {
                break;
            }

            bitsOfCurrent++;
            if (currentCountOfNumbers > Integer.MAX_VALUE / 10) {
                break;
            }

            nCopy = nCopy - currentTotalBits;
            currentBaseNumber += currentCountOfNumbers;

            currentCountOfNumbers *= 10;
            if (bitsOfCurrent > Integer.MAX_VALUE / currentCountOfNumbers) {
                break;
            }
            currentTotalBits = bitsOfCurrent * currentCountOfNumbers;
        }

        while (true) {

            currentBaseNumber++;

            if (nCopy <= bitsOfCurrent) {
                break;
            }
            nCopy -= bitsOfCurrent;
        }

        String currentBaseNumberString = Integer.toString(currentBaseNumber);

        return currentBaseNumberString.charAt(nCopy - 1) - '0';
    }
}