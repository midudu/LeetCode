/*
  Given an integer (signed 32 bits), write a function to check whether it is a
power of 4.

Example:
  Given num = 16, return true. Given num = 5, return false.

Follow up:
  Could you solve it without loops/recursion?
*/

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().isPowerOfFour(6));
    }

    public boolean isPowerOfFour(int num) {

        if (num <= 0) {
            return false;
        }

        int mask = 0xAAAAAAAA;
        if ((num & mask) != 0) {
            return false;
        }

        return ((num & (num - 1)) == 0);
    }
}
