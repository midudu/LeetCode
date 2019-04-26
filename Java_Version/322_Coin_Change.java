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

// Method 1:
/*
class Solution {

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        new Solution().coinChangeHelper(coins, amount);
    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }

        if (coins == null || coins.length == 0) {
            return -1;
        }

        Arrays.sort(coins);

        int[] result = new int[amount + 1];
        Arrays.fill(result, amount + 1);
        result[0] = 0;

        for (int currentAmount = 1; currentAmount < result.length; currentAmount++) {

            for (int j = 0; j < coins.length; j++) {

                if (coins[j] > currentAmount) {
                    break;
                }

                result[currentAmount] = Math.min(result[currentAmount],
                        result[currentAmount - coins[j]] + 1);
            }
        }

        return (result[amount] == amount + 1 ? -1 : result[amount]);
    }
}*/


// Method 2
public class Solution {

    private int result = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        if (coins == null || coins.length == 0) {
            return -1;
        }

        Arrays.sort(coins);

        coinChangeHelper(amount, coins.length - 1, coins,
                0);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void coinChangeHelper(int amount, int currentUsingCoinIndex, int[] coins,
                                  int existingCoinNumber) {

        if (currentUsingCoinIndex < 0 || existingCoinNumber >= result - 1) {
            return;
        }

        int maxCurrentCoinNumber = amount / coins[currentUsingCoinIndex];

        for (int i = maxCurrentCoinNumber; i >= 0; i--) {

            int newCount = existingCoinNumber + i;

            int leftAmount = amount - i * coins[currentUsingCoinIndex];

            if (leftAmount == 0) {
                if (newCount < this.result) {
                    result = newCount;
                }
            } else {
                if (newCount < this.result) {
                    coinChangeHelper(leftAmount, currentUsingCoinIndex - 1,
                            coins, newCount);
                }
            }

            if (newCount >= result - 1) {
                break;
            }
        }
    }
}