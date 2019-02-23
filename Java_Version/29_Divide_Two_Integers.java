/*
Given two integers dividend and divisor,
divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
        Input: dividend = 10, divisor = 3
        Output: 3

        Example 2:

        Input: dividend = 7, divisor = -3
        Output: -2
        Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.

Assume we are dealing with an environment which could only store
integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
For the purpose of this problem, assume that your function returns 2^31 − 1
when the division result overflows.*/

// Method 1: hard but not Use Long
class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        return isNegative ? -division(dividend, divisor) :
                division(dividend, divisor);
    }

    private int division(int dividend, int divisor) {

        if (dividend > divisor) {
            return 0;
        }

        int currSum = divisor << 1;
        int prevSum = divisor;
        int quotient = 1;

        while (dividend <= currSum && currSum < prevSum) {
            prevSum = currSum;
            currSum <<= 1;
            quotient <<= 1;
        }

        return quotient + division(dividend - prevSum, divisor);
    }
}

// Method 2: easy but use Long
/*
public class Solution {

    public int divide(int dividend, int divisor) {

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int count = 0;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        while (a - b >= 0) {

            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            count += 1 << (shift - 1);
        }
        return ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) ? -count : count;
    }
}*/
