/*
  Write a program to find the nth super ugly number.

  Super ugly numbers are positive numbers whose all prime factors are in the
given prime list primes of size k.

Example:

        Input: n = 12, primes = [2,7,13,19]
        Output: 32

        Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the
first 12 super ugly numbers given primes = [2,7,13,19] of size 4.

Note:

        1 is a super ugly number for any given primes.

        The given numbers in primes are in ascending order.

        0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

        The nth super ugly number is guaranteed to fit in a 32-bit signed
integer.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        int n = 12;

        int[] primes = {2, 7, 13, 19};

        new Solution().nthSuperUglyNumber(n, primes);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {

        if (n == 1) {
            return 1;
        }

        int[] results = new int[n];
        results[0] = 1;

        int[] lastMultiplyNumberIndex = new int[primes.length];

        for (int i = 1; i < n; i++) {

            int minValue = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {

                int currentValue = primes[j] * results[lastMultiplyNumberIndex[j]];
                minValue = Math.min(minValue, currentValue);
            }

            results[i] = minValue;

            for (int j = 0; j < primes.length; j++) {

                int currentValue = primes[j] * results[lastMultiplyNumberIndex[j]];
                if (currentValue == minValue) {
                    lastMultiplyNumberIndex[j]++;
                }
            }
        }

        return results[results.length - 1];
    }
}