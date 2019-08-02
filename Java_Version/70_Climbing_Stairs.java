/*
  You are climbing a stair case. It takes n steps to reach to the top. Each
time you can either climb 1 or 2 steps. In how many distinct ways can you climb
to the top?

Note:
  Given n will be a positive integer.

Example 1:

        Input: 2
        Output:  2
        Explanation:  There are two ways to climb to the top.

        1. 1 step + 1 step
        2. 2 steps

Example 2:

        Input: 3
        Output:  3
        Explanation:  There are three ways to climb to the top.

        1. 1 step + 1 step + 1 step
        2. 1 step + 2 steps
        3. 2 steps + 1 step
*/


class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
    }

    public int climbStairs(int n) {

        if (n <= 0) {
            throw new RuntimeException("n <= 0");
        } else if (n == 1) {
            return 1;
        }

        int lastTwoResult = 1;
        int lastResult = 1;

        for (int currentStep = 2; currentStep <= n; currentStep++) {
            int currentResult = lastTwoResult + lastResult;
            lastTwoResult = lastResult;
            lastResult = currentResult;
        }

        return lastResult;
    }
}
