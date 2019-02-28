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

class Solution {

    public static void main(String[] args) {

        new Solution().divide(-2147483648, -1);
    }

    public int divide(int dividend, int divisor) {

        if (dividend == 0x7FFFFFFF && divisor == -1) {
            return 0x7FFFFFFF;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend > 0 && divisor > 0) {
            return divideHelper(-dividend, -divisor);
        } else if (dividend > 0 && divisor < 0) {
            return -divideHelper(-dividend, divisor);
        } else if (dividend < 0 && divisor > 0) {
            return -divideHelper(dividend, -divisor);
        } else {
            return divideHelper(dividend, divisor);
        }
    }

    private int divideHelper(int dividend, int divisor) {

        int result = 0;

        while (dividend <= divisor) {

            int movingBit = 0;
            while (dividend < (divisor << movingBit)) {

                int currentResult = (divisor << movingBit);
                movingBit++;
            }

            result += (1 << (movingBit - 1));

            dividend -= (divisor << (movingBit - 1));
        }

        return result;
    }
}

