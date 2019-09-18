/*
  Calculate the sum of two integers a and b, but you are not allowed to use the
operator + and -.

Example 1:

        Input: a = 1, b = 2
        Output: 3

Example 2:

        Input: a = -2, b = 3
        Output: 1
*/

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().getSum(-2, 3));
    }

    public int getSum(int a, int b) {

        int carryBit = 0;
        int result = 0;
        int index = 0;

        while (a != 0 || b != 0 || carryBit != 0) {

            int aBit = (a & 1);
            int bBit = (b & 1);

            int sumBit = (aBit ^ bBit ^ carryBit);
            carryBit = ((aBit ^ bBit) & carryBit) | (aBit & bBit);

            result |= (sumBit << (index));

            index++;
            a >>>= 1;
            b >>>= 1;

            if (index == 32) {
                break;
            }
        }

        return result;
    }
}
