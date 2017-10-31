//Given an array of integers and an integer k, you need to find the number of unique k - diff pairs in the array.Here a k - diff pair is defined as an integer pair(i, j), where i and j are both numbers in the array and their absolute difference is k.
//
//Example 1:
//Input: [3, 1, 4, 1, 5], k = 2
//	Output : 2
//	Explanation : There are two 2 - diff pairs in the array, (1, 3) and (3, 5).
//	Although we have two 1s in the input, we should only return the number of unique pairs.
//	Example 2 :
//	Input : [1, 2, 3, 4, 5], k = 1
//	Output : 4
//	Explanation : There are four 1 - diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
//	Example 3 :
//	Input : [1, 3, 1, 5, 4], k = 0
//	Output : 1
//	Explanation : There is one 0 - diff pair in the array, (1, 1).
//	Note :
//	The pairs(i, j) and (j, i) count as the same pair.
//	The length of the array won't exceed 10,000.
//	All the integers in the given input belong to the range : [-1e7, 1e7].

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
	int findPairs(vector<int>& nums, int k) {
		int nums_size = (int)nums.size();
		if (nums_size < 2)
			return 0;

		sort(nums.begin(), nums.end());
		int slow = 0, fast = 1;
		int result = 0;

		while (fast<nums_size)
		{
			if (nums[fast] - nums[slow] > k)
			{
				slow++;
				if (slow == fast)
					fast++;
			}
			else if (nums[fast] - nums[slow] < k)
			{
				fast++;
			}
			else
			{
				result++;
				slow++;
				fast++;

				while (fast != nums_size)
				{
					if (nums[fast] == nums[fast - 1])
						fast++;
					else
						break;
				}
				while (slow != nums_size)
				{
					if (nums[slow] == nums[slow - 1])
						slow++;
					else
						break;
				}
				if (slow == fast)
					fast++;
			}
		}

		return result;
	}
};

int main()
{
	Solution sol1;
	
	vector<int> nums1({ 1, 1, 1, 1, 1 });

	int receive = sol1.findPairs(nums1, 0);

	system("pause");

	return 0;
}