//Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
//say(a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n 
//as large as possible.
//
//Example 1:
//Input: [1, 4, 3, 2]
//
//	Output : 4
//	Explanation : n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
//	Note :
//	n is a positive integer, which is in the range of[1, 10000].
//	All the integers in the array will be in the range of[-10000, 10000].


//   1,2,3,4,5,6,7,8


#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
using namespace std;


class Solution {
public:
	int arrayPairSum(vector<int>& nums) {
		sort(nums.begin(), nums.end(), less<int>());

		int sum = 0;

		for (int i = 0; i < (int)nums.size(); i += 2)
		{
			sum += nums[i];
		}

		return sum;
	}
};



int main()
{
	vector<int> number;
	number.push_back(-1);
	number.push_back(-2);
	number.push_back(3);
	number.push_back(-6);
	number.push_back(1);
	number.push_back(9);
	number.push_back(2);

	Solution sol1;
	sol1.arrayPairSum(number);


	for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';

	system("pause");

	return 0;
}