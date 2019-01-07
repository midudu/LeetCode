/*
Given a range [m, n] where 0 <= m <= n <= 2147483647,

return the bitwise AND of all numbers in this range, inclusive.

        Example 1:

        Input: [5,7]
        Output: 4


        Example 2:

        Input: [0,1]
        Output: 0*/

class Solution {

    public int rangeBitwiseAnd(int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }

        int mask = (1 << 30);
        int result = 0;

        while (mask != 0) {

            int currentBitM = mask & m;
            int currentBitN = mask & n;

            // which means there are at least two numbers 0xxxxxx and 1000000
            // and their bitwise-and result is 0
            if (currentBitM != currentBitN) {
                return result;
            }

            result |= currentBitM;

            mask >>= 1;
        }

        return result;
    }
}