/*
  Say you have an array for which the ith element is the price of a given stock
on day i. Design an algorithm to find the maximum profit. You may complete at
most two transactions.

Note:
  You may not engage in multiple transactions at the same time (i.e., you must
sell the stock before you buy again).

Example 1:

        Input: [3,3,5,0,0,3,1,4]
        Output: 6

        Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3),
        profit = 3-0 = 3. Then buy on day 7 (price = 1) and sell on day 8
        (price = 4), profit = 4-1 = 3.

Example 2:

        Input: [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5),
        profit = 5-1 = 4. Note that you cannot buy on day 1, buy on day 2 and
        sell them later, as you are engaging multiple transactions at the same
        time. You must sell before buying again.

Example 3:

        Input: [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        int[] prices = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};

        System.out.println(new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        List<Integer> valley = new ArrayList<>(prices.length);
        List<Integer> peek = new ArrayList<>(prices.length);

        int startIndex = 0;
        int currentIndex = 1;
        while (currentIndex < prices.length) {
            while (currentIndex < prices.length &&
                    prices[currentIndex] >= prices[currentIndex - 1]) {
                currentIndex++;
            }

            if (prices[currentIndex - 1] > prices[startIndex]) {
                peek.add(prices[currentIndex - 1]);
                valley.add(prices[startIndex]);
            }

            startIndex = currentIndex;
            currentIndex++;
        }

        if (peek.size() == 0) {
            return 0;
        } else if (peek.size() == 1) {
            return peek.get(0) - valley.get(0);
        } else if (peek.size() == 2) {
            return (peek.get(0) - valley.get(0)) + (peek.get(1) - valley.get(1));
        }

        int result = 0;
        for (int i = 0; i < peek.size(); i++) {

            for (int )
        }
    }
}
