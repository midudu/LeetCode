/*
  Given a non-negative integer n, count all numbers with unique digits, x,
where 0 ≤ x < 10^n.

Example:

        Input: 2
        Output: 91

Explanation:
  The answer should be the total numbers in the range of 0 ≤ x < 100, excluding
11,22,33,44,55,66,77,88,99
*/

class Solution {

    public int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }

        int[] result = new int[n + 1];
        result[0] = 1;

        for (int i = 1; i < n + 1; i++) {

            if (i > 10) {
                result[i] = result[i - 1];
                continue;
            }

            int currentResult = 9;
            int currentNum = 9;

            for (int j = i - 1; j > 0; j--) {
                currentResult *= currentNum;
                currentNum--;
            }

            result[i] += result[i - 1] + currentResult;
        }

        return result[n];
    }
}