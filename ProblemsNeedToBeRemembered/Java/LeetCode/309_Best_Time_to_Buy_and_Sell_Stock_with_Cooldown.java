/*
  Say you have an array for which the ith element is the price of a given stock
on day i.

  Design an algorithm to find the maximum profit. You may complete as many
transactions as you like (ie, buy one and sell one share of the stock multiple
times) with the following restrictions:

  You may not engage in multiple transactions at the same time (ie, you must
sell the stock before you buy again).

  After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

        Input: [1,2,3,0,2]
        Output: 3
        Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

class Solution {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int[] holdingStockProfitOfEachDay = new int[prices.length];
        int[] notHoldingStockProfitOfEachDay = new int[prices.length];

        holdingStockProfitOfEachDay[0] = -prices[0];

        for (int currentDay = 1; currentDay < prices.length; currentDay++) {

            holdingStockProfitOfEachDay[currentDay]
                    = Math.max(holdingStockProfitOfEachDay[currentDay - 1],
                    (currentDay == 1 ? -prices[currentDay] :
                            notHoldingStockProfitOfEachDay[currentDay - 2]
                                    - prices[currentDay]));

            notHoldingStockProfitOfEachDay[currentDay]
                    = Math.max(
                    holdingStockProfitOfEachDay[currentDay - 1] + prices[currentDay],
                    notHoldingStockProfitOfEachDay[currentDay - 1]);
        }

        return notHoldingStockProfitOfEachDay[prices.length - 1];
    }
}