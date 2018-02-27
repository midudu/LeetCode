/*Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

        Substrings that occur multiple times are counted the number of times they occur.

        Example 1:
        Input: "00110011"
        Output: 6
        Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

        Notice that some of these substrings repeat and are counted the number of times they occur.

        Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
        Example 2:
        Input: "10101"
        Output: 4
        Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
        Note:

        s.length will be between 1 and 50,000.
        s will only consist of "0" or "1" characters.*/


import java.lang.System;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.lang.Math;


public class Main
{
    public static void main(String[] args)
    {
        String input = "10101";

        Solution solution = new Solution();

        int receiveFlag = solution.countBinarySubstrings(input);

        System.out.println("haha");

    }


}


class Solution {

    public int countBinarySubstrings(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }

        return findConsecutiveCount(s);

    }

    private int findConsecutiveCount(String s) {
        int sLength = s.length();
        int count = 1;
        int lastConsecutiveCount = 0;
        int returnValue = 0;

        for (int i = 1; i < sLength; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                returnValue += Math.min(lastConsecutiveCount, count);

                lastConsecutiveCount = count;
                count = 1;
            } else {
                count++;
            }
        }

        returnValue += Math.min(lastConsecutiveCount, count);

        return returnValue;
    }
}