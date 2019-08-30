/*
  Given an integer, write a function to determine if it is a power of three.

Follow up:
  Could you do it without using any loop / recursion?
*/


class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().isPowerOfThree(9));
    }

    public boolean isPowerOfThree(int n) {

        if (n <= 0) {
            return false;
        }

        return isPowerOfThreeHelper(n);
    }

    private boolean isPowerOfThreeHelper(int n) {

        if (n == 1) {
            return true;
        }

        if (n % 3 != 0) {
            return false;
        }

        return isPowerOfThreeHelper(n / 3);
    }
}
