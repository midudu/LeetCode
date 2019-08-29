/*
  You are given coins of different denominations and a result amount of money
amount. Write a function to compute the fewest number of coins that you need to
make up that amount. If that amount of money cannot be made up by any
combination of the coins, return -1.

Example 1:

  Input: coins = [1, 2, 5], amount = 11
  Output: 3
  Explanation: 11 = 5 + 5 + 1

Example 2:

  Input: coins = [2], amount = 3
  Output: -1

Note:
  You may assume that you have an infinite number of each kind of coin.
*/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] coins = {2};
        int amount = 3;

        System.out.println(new Solution().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return (amount == 0 ? 0 : -1);
        }
        if (amount < 0) {
            return -1;
        } else if (amount == 0) {
            return 0;
        }

        Arrays.sort(coins);

        int[] result = new int[amount + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {
                if (coin > i) {
                    break;
                }
                if (result[i - coin] != Integer.MAX_VALUE) {
                    result[i] = Math.min(result[i], result[i - coin] + 1);
                }
            }
        }

        return (result[amount] == Integer.MAX_VALUE ? -1 : result[amount]);
    }
}
