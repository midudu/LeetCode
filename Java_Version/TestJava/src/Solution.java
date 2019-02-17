/*Given a 32-bit signed integer, reverse digits of an integer.

        Example 1:

        Input: 123
        Output:  321

        Example 2:

        Input: -123
        Output: -321
        Example 3:

        Input: 120
        Output: 21

Note:
Assume we are dealing with an environment which could only hold integers within
the 32-bit signed integer range. For the purpose of this problem, assume that
your function returns 0 when the reversed integer overflows.*/

// Method 1: long unsupported
class Solution {

    public int reverse(int x) {

        int finalResult = 0;

        while (x != 0) {

            // The result of a negative number % 10 is still negative
            int tail = x % 10;

            int currentResult = finalResult * 10 + tail;

            // Overflow happens
            if (currentResult / 10 != finalResult) {
                return 0;
            }

            finalResult = currentResult;
            x /= 10;
        }

        return finalResult;
    }
}

// Method 2: long supported
/*
class Solution {

    public int reverse(int x) {

        long result = 0;

        while (x != 0) {

            result = result * 10 + (x % 10);

            x /= 10;
        }

        return ((int) result == result ? (int)result : 0);
    }
}*/
