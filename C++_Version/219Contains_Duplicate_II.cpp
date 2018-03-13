//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

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
	bool containsNearbyDuplicate(vector<int>& nums, int k) {
		map<int, int> storage;

		for (int i = 0; i < (int)nums.size(); ++i)
		{
			if ( storage.find(nums[i]) != storage.end() && i - storage[nums[i]] <= k)
			{
				return true;
			}
			else
			{
				storage[nums[i]] = i;
			}
		}

		return false;
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