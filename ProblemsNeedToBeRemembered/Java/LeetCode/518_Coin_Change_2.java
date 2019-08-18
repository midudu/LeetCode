/*
  You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that
amount. You may assume that you have infinite number of each kind of coin.

Example 1:

        Input: amount = 5, coins = [1, 2, 5]
        Output: 4
        Explanation: there are four ways to make up the amount:
        5=5
        5=2+2+1
        5=2+1+1+1
        5=1+1+1+1+1

Example 2:

        Input: amount = 3, coins = [2]
        Output: 0
        Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:

        Input: amount = 10, coins = [10]
        Output: 1

Note:
  You can assume that
        0 <= amount <= 5000
        1 <= coin <= 5000
        the number of coins is less than 500
        the answer is guaranteed to fit into signed 32-bit integer
*/

// 带记忆的 top-down
class Solution1 {

    public int change(int amount, int[] coins) {

        Integer[][] ways = new Integer[coins.length][amount + 1];
        return changeWays(amount, coins, 0, ways);
    }

    private int changeWays(int amount, int[] coins, int startIndex, Integer[][] ways) {

        if (amount == 0) {
            return 1;
        }
        if (startIndex >= coins.length) {
            return 0;
        }

        if (ways[startIndex][amount] != null) {
            return ways[startIndex][amount];
        }

        int way1 = 0;
        if (amount >= coins[startIndex]) {
            way1 = changeWays(amount - coins[startIndex], coins, startIndex, ways);
        }

        int way2 = changeWays(amount, coins, startIndex + 1, ways);
        ways[startIndex][amount] = way1 + way2;
        return way1 + way2;
    }
}

// bottom-up
class Solution2 {

    public static void main(String[] args) {

        System.out.println(new Solution2().change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {

        int[][] ways = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < ways.length; i++) {
            ways[i][0] = 1;
        }

        for (int firstN = 1; firstN <= coins.length; firstN++) {
            for (int sum = 1; sum <= amount; sum++) {

                ways[firstN][sum] = ways[firstN - 1][sum];

                if (coins[firstN - 1] <= sum) {
                    ways[firstN][sum] += ways[firstN][sum - coins[firstN - 1]];
                }
            }
        }

        return ways[coins.length][amount];
    }
}

// bottom-up，节约空间
class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {

        int[] ways = new int[amount + 1];
        ways[0] = 1;

        for (int firstN = 1; firstN <= coins.length; firstN++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[firstN - 1] > j) {
                    continue;
                }
                ways[j] += ways[j - coins[firstN - 1]];
            }
        }

        return ways[amount];
    }
}
