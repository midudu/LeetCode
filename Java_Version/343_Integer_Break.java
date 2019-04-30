/*
  Given a positive integer n, break it into the sum of at least two positive
integers and maximize the product of those integers. Return the maximum product
you can get.

  Example 1:

        Input: 2
        Output: 1
        Explanation: 2 = 1 + 1, 1 × 1 = 1.

        Example 2:

        Input: 10
        Output: 36
        Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.

  Note: You may assume that n is not less than 2 and not larger than 58.
*/

class Solution {

    public static void main(String[] args) {

        new Solution().integerBreak(10);
    }

    public int integerBreak(int n) {

        if (n < 2) {
            throw new RuntimeException("Illegal input");
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;

        for (int i = 4; i < n + 1; i++) {

            for (int j = 1; j <= i / 2; j++) {

                //result[i] = Math.max(j * (i - j), result[i]);
                result[i] = Math.max(result[j] * result[i - j], result[i]);
            }

            //System.out.println(result[i]);
        }

        return result[n];
    }
}