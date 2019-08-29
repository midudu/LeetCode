/*
  Say you have an array for which the ith element is the price of a given stock
on day i.

  Design an algorithm to find the maximum profit. You may complete as many
transactions as you like (ie, buy one and sell one share of the stock multiple
times) with the following restrictions:

  You may not engage in multiple transactions at the same time (ie, you must
sell the stock before you buy again).

  After you sell your stock, you cannot buy stock on next day. (ie, cooldown
1 day)

Example:

        Input: [1,2,3,0,2]
        Output: 3
        Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

class Solution {

    public static void main(String[] args) {

        int[] prices = {1, 2, 3, 0, 2};

        System.out.println(new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] maxProfitOfHoldingStock = new int[prices.length];
        int[] maxProfitOfNotHoldingStock = new int[prices.length];

        maxProfitOfHoldingStock[0] = -prices[0];
        maxProfitOfHoldingStock[1] = Math.max(-prices[0], -prices[1]);
        maxProfitOfNotHoldingStock[0] = 0;
        maxProfitOfNotHoldingStock[1] = Math.max(0, prices[1] - prices[0]);

        for (int i = 2; i < prices.length; i++) {

            maxProfitOfHoldingStock[i] = Math.max(
                    maxProfitOfHoldingStock[i - 1], maxProfitOfNotHoldingStock[i - 2] - prices[i]);

            maxProfitOfNotHoldingStock[i] = Math.max(
                    maxProfitOfNotHoldingStock[i - 1], maxProfitOfHoldingStock[i - 1] + prices[i]);

        }

        return maxProfitOfNotHoldingStock[prices.length - 1];
    }
}
