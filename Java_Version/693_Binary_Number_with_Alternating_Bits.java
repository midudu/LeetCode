/*
  Given a positive integer, check whether it has alternating bits: namely, if
two adjacent bits will always have different values.

Example 1:

        Input: 5
        Output: True

        Explanation:
          The binary representation of 5 is: 101

Example 2:

        Input: 7
        Output: False

        Explanation:
          The binary representation of 7 is: 111.

Example 3:

        Input: 11
        Output: False

        Explanation:
        The binary representation of 11 is: 1011.

Example 4:

        Input: 10
        Output: True
        Explanation:
        The binary representation of 10 is: 1010.
*/

class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.hasAlternatingBits(5));
        System.out.println(solution.hasAlternatingBits(7));
        System.out.println(solution.hasAlternatingBits(11));
        System.out.println(solution.hasAlternatingBits(10));
    }

    public boolean hasAlternatingBits(int n) {

        if (n <= 0) {
            throw new RuntimeException("illegal input");
        }

        int lastBit = (n & 1);

        while (n != 0) {

            n >>= 1;
            int currentBit = (n & 1);

            if (currentBit == lastBit) {
                return false;
            }

            lastBit = currentBit;
        }

        return true;
    }
}