/*

Implement int sqrt(int x). Compute and return the square root of x.

x is guaranteed to be a non-negative integer.


        Example 1:

        Input: 4
        Output: 2
        Example 2:

        Input: 8
        Output: 2

        Explanation: The square root of 8 is 2.82842..., and since we want to
        return an integer, the decimal part will be truncated.
*/


class Solution {

    public int mySqrt(int x) {

        if (x == 0) {
            return 0;
        }

        int startIndex = 0, endIndex = x;

        while (startIndex < endIndex - 1) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            int currentResult = x / middleIndex;

            if (currentResult == middleIndex) {
                return middleIndex;
            } else if (currentResult < middleIndex) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex;
            }
        }

        return (endIndex <= x / endIndex ? endIndex : startIndex);
    }
}