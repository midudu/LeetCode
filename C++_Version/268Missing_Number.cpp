//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
//
//For example,
//Given nums = [0, 1, 3] return 2.
//
//Note:
//Your algorithm should run in linear runtime complexity.Could you implement it using only constant extra space complexity ?

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
	int missingNumber(vector<int>& nums) {
		int sum = 0;
		int n = (int)nums.size();

		for (int i = 0; i < (int)nums.size(); ++i)
		{
			sum += nums[i];
		}

		return n * (n + 1) / 2 - sum;
	}
};

int main()
{
	Solution sol1;
	
	vector<int> nums1({ 1, 2, 3 });

	int receive = sol1.missingNumber(nums1);

	system("pause");

	return 0;
}