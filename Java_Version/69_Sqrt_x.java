/*
  Implement int sqrt(int x). Compute and return the square root of x.
x is guaranteed to be a non-negative integer.

Example 1:

        Input: 4
        Output: 2

Example 2:

        Input: 8
        Output: 2

        Explanation:
          The square root of 8 is 2.82842..., and since we want to return an
        integer, the decimal part will be truncated.
*/


class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.mySqrt(4));
        System.out.println(solution.mySqrt(8));
    }

    public int mySqrt(int x) {

        if (x < 0) {
            throw new RuntimeException("x < 0");
        } else if (x == 0) {
            return 0;
        }

        int start = 0, end = x;
        while (start < end - 1) {

            int middleIndex = start + (end - start) / 2;
            int currentResult = x / middleIndex;

            if (currentResult == middleIndex) {
                return middleIndex;
            } else if (currentResult < middleIndex) {
                end = middleIndex - 1;
            } else {
                start = middleIndex;
            }
        }

        return (end <= x / end ? end : start);
    }
}
