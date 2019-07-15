/*
  Given a non-negative integer c, your task is to decide whether there're two
integers a and b such that a^2 + b^2 = c.

Example 1:

        Input: 5
        Output: True
        Explanation: 1 * 1 + 2 * 2 = 5

Example 2:

        Input: 3
        Output: False
*/


class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().judgeSquareSum(1000000000));
    }

    public boolean judgeSquareSum(int c) {

        int start = 0, end = (int) Math.sqrt(c);

        while (start <= end
                && start * start != c - end * end) {

            if (start * start < c - end * end) {
                start++;
            } else {
                end--;
            }
        }

        return start <= end;
    }
}