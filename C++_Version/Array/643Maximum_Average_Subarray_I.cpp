//Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value.And you need to output the maximum average value.
//
//Example 1:
//Input: [1, 12, -5, -6, 50, 3], k = 4
//	Output : 12.75
//	Explanation : Maximum average is(12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
//	Note :
//	1 <= k <= n <= 30, 000.
//	Elements of the given array will be in the range[-10, 000, 10, 000].

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
	double findMaxAverage(vector<int>& nums, int k) {

		int last_index = (int)nums.size() - k;
		int temp_sum = 0, last_sum = 0;
		int max_sum = 0;

		for (int i = 0; i < k; ++i)
			max_sum += nums[i];
		last_sum = max_sum;


		for (int i = 1; i <= last_index; ++i)
		{
			temp_sum = last_sum - nums[i - 1] + nums[i + k - 1];
			last_sum = temp_sum;
			if (temp_sum > max_sum)
				max_sum = temp_sum;
		}

		return static_cast<double>(max_sum) / k;
	}
};

int main()
{
	Solution sol1;
	
	vector<int> nums1({ 1, 2, 3 });

	int receive = sol1.findMaxAverage(nums1);

	system("pause");

	return 0;
}