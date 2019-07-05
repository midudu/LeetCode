/*
  Given two integers n and k, you need to construct a list which contains n
different positive integers ranging from 1 to n and obeys the following
requirement:

  Suppose this list is [a1, a2, a3, ... , an], then the list
[|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct
integers.

  If there are multiple answers, print any of them.

Example 1:

        Input: n = 3, k = 1
        Output: [1, 2, 3]

        Explanation:
          The [1, 2, 3] has three different positive integers ranging from 1 to
        3, and the [1, 1] has exactly 1 distinct integer: 1.

Example 2:

        Input: n = 3, k = 2
        Output: [1, 3, 2]

        Explanation:
          The [1, 3, 2] has three different positive integers ranging from 1 to
        3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.

Note:
        The n and k are in the range 1 <= k < n <= 104.
*/


import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        int[] result = new Solution().constructArray(6, 1);

        System.out.println(Arrays.toString(result));
    }

    public int[] constructArray(int n, int k) {

        if ( k < 1 || n <= k) {
            throw new RuntimeException("Illegal input parameters");
        }

        int[] result = new int[n];
        result[0] = 1;

        int pointer = 1;
        boolean increaseFlag = true;

        for (int i = k - 1, j = n - 1; i > 0; i--, j--) {

            if (increaseFlag) {
                result[pointer] = result[pointer - 1] + j;
            } else {
                result[pointer] = result[pointer - 1] - j;
            }

            increaseFlag = !increaseFlag;
            pointer++;
        }

        for (int i = pointer; i < result.length; i++) {
            if (increaseFlag) {
                result[i] = result[i-1] + 1;
            } else {
                result[i] = result[i-1] - 1;
            }
        }

        return result;
    }
}