/*
  Given a non negative integer number num. For every numbers i in the range
0 ≤ i ≤ num calculate the number of 1's in their binary representation and
return them as an array.

  Example 1:

        Input: 2
        Output: [0,1,1]

  Example 2:

        Input: 5
        Output: [0,1,1,2,1,2]

Follow up:

  It is very easy to come up with a solution with run time O(n*sizeof(integer)).
But can you do it in linear time O(n) /possibly in a single pass? Space
complexity should be O(n).

  Can you do it like a boss? Do it without using any builtin function like
  __builtin_popcount in c++ or in any other language.
*/


import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution().countBits(8)));
    }

    public int[] countBits(int num) {

        if (num < 0) {
            throw new RuntimeException("Illegal input!");
        } else if (num == 0) {
            return new int[]{0};
        }

        int[] result = new int[num + 1];
        result[1] = 1;

        int standardElement = 1;

        for (int i = 2; i < result.length; i++) {

            if (i == (standardElement << 1)) {
                standardElement <<= 1;
            }

            result[i] = result[i - standardElement] + 1;
        }

        return result;
    }
}
