/*
  Given a positive integer num, write a function which returns True if num is
a perfect square else False.

Note:
  Do not use any built-in library function such as sqrt.

Example 1:

        Input: 16
        Returns: True

Example 2:

        Input: 14
        Returns: False
*/


class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().isPerfectSquare(14));
    }

    public boolean isPerfectSquare(int num) {

        if (num <= 0) {
            throw new RuntimeException("illegal input");
        }

        return isPerfectSquareHelper(num, 1, num);
    }

    private boolean isPerfectSquareHelper(int num, int start, int end) {

        if (start == end) {
            return num == start * start;
        }

        int middle = start + (end - start) / 2;
        int dividedResult = num / middle;

        if (middle == dividedResult) {
            if (middle * middle == num) {
                return true;
            } else {
                return isPerfectSquareHelper(num, middle + 1, end);
            }
        }

        if (middle < dividedResult) {
            return isPerfectSquareHelper(num, middle + 1, end);
        } else {
            return isPerfectSquareHelper(num, start, middle);
        }
    }
}
