//Given an array of size n, find the majority element.The majority element is the element that appears more than ⌊ n / 2 ⌋ times.
//
//You may assume that the array is non - empty and the majority element always exist in the array.

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
	int majorityElement(vector<int>& nums) {
		sort(nums.begin(), nums.end(), less<int>());

		int nums_size = (int)nums.size();

		for (int i = 0; i < nums_size; ++i)
		{
			if (nums[i] == nums[i + nums_size / 2])
				return nums[i];
		}
	}
};

int main()
{
	Solution sol1;
	
	vector<int> nums1 = { 1 };

	int receive = sol1.majorityElement(nums1);

	system("pause");

	return 0;
}