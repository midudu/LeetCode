//Say you have an array for which the ith element is the price of a given stock on day i.
//
//Design an algorithm to find the maximum profit.You may complete as many transactions as you like(ie, buy one and sell one share of the stock multiple times).However, you may not engage in multiple transactions at the same time(ie, you must sell the stock before you buy again).

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <unordered_map>
#include <map>
#include <set>
#include <unordered_set>
using namespace std;

class Solution {
public:
	int maxProfit(vector<int>& prices) {
		int max_profit = 0;
		for (int i = 1; i < (int)prices.size(); ++i)
		{
			max_profit += std::max(prices[i] - prices[i - 1], 0);
		}

		return max_profit;
	}
};

int main()
{
	Solution sol1;
	
	vector<int> nums1({ 1, 2, 3 });

	vector<int> receive = sol1.getRow(4);

	system("pause");

	return 0;
}