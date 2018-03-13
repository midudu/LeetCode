//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//Example 1:
//Input: [7, 1, 5, 3, 6, 4]
//	Output : 5
//
//	max.difference = 6 - 1 = 5 (not 7 - 1 = 6, as selling price needs to be larger than buying price)
//	Example 2 :
//	Input : [7, 6, 4, 3, 1]
//	Output : 0
//
//	In this case, no transaction is done, i.e.max profit = 0.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
using namespace std;

class Solution {
public:
	int maxProfit(vector<int>& prices) {
		if (prices.size() <= 1)
			return 0;
		
		int min = prices[0];
		int size = prices.size();
		int delta = 0,delta_max = 0;

		for (int i = 1; i < size; ++i)
		{
			if (prices[i] <= min)
				min = prices[i];

			else
			{
				delta = prices[i] - min;
				if (delta > delta_max)
					delta_max = delta;
			}
		}

		return delta_max;
	}
};


int main()
{
	vector<int> vec1({ 7, 6, 4, 3, 1 });

	Solution sol1;
	int ret1 = sol1.maxProfit(vec1);

	/*for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';*/

	system("pause");

	return 0;
}