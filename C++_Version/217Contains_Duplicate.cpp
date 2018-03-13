//Given an array of integers, find if the array contains any duplicates.Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

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
	bool containsDuplicate(vector<int>& nums) {
		int num_size = (int)nums.size();
		if (num_size <= 1)
			return false;

		//set<int> nums_set;
		unordered_set<int> nums_set;

		for (int i = 0; i < num_size; ++i)
		{
			if (!nums_set.insert(nums[i]).second)
				return true;
		}
		return false;
	}
};


int main()
{
	Solution sol1;
	
	vector<int> nums({ 1,2,3,4,5,6 });

	bool receive = sol1.containsDuplicate(nums);

	system("pause");

	return 0;
}