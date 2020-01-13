//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return[0, 1].


#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <queue>
#include <unordered_map>
using namespace std;


class Solution {
public:
	vector<int> twoSum(vector<int>& nums, int target) {
		int size = nums.size();

		vector<int> output;
		unordered_map<int, int> hash_table;

		for (int i = 0; i < size; ++i)
		{
			int temp = target - nums[i];

			if (hash_table.find(temp) != hash_table.end())
			{
				output.push_back(hash_table[temp]);
				output.push_back(i);
				return output;
			}

			hash_table[nums[i]] = i;
		}

		return output;
	}
};

int main()
{
	vector<int> nums({ 2,7,11,5 });

	Solution sol1;

	vector<int> receive = sol1.twoSum(nums, 9);

	system("pause");

	return 0;
}