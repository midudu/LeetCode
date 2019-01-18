/*
Write a program to find the n-th ugly number.

        Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

        Example:

        Input: n = 10
        Output: 12
        Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
        Note:

        1 is typically treated as an ugly number.
        n does not exceed 1690.*/

class Solution {

    public int nthUglyNumber(int n) {

        int[] result = new int[n];
        result[0] = 1;

        int twoExistingProductPointer = 0;
        int threeExistingProductPointer = 0;
        int fiveExistingProductPointer = 0;

        for (int i = 1; i < n; i++) {

            result[i] = Math.min(
                    Math.min(result[twoExistingProductPointer] * 2,
                            result[threeExistingProductPointer] * 3),
                    result[fiveExistingProductPointer] * 5);

            if (result[twoExistingProductPointer] * 2 == result[i]) {
                twoExistingProductPointer++;
            }

            if (result[threeExistingProductPointer] * 3 == result[i]) {
                threeExistingProductPointer++;
            }

            if (result[fiveExistingProductPointer] * 5 == result[i]) {
                fiveExistingProductPointer++;
            }
        }

        return result[n - 1];
    }
}