/*
  Reverse bits of a given 32 bits unsigned integer.

  For example, given input 43261596 (represented in binary as
00000010100101000001111010011100), return 964176192 (represented in binary as
00111001011110000010100101000000).

Follow up:
  If this function is called many times, how would you optimize it?
*/


class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().reverseBits(43261596));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            if (n == 0) {
                return (result << (32 - i));
            }

            int currentBit = (n & 1);
            result = (result << 1) + currentBit;
            n >>>= 1;
        }

        return result;
    }
}
