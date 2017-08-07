//Find the contiguous subarray within an array(containing at least one number) which has the largest sum.
//
//For example, given the array[-2, 1, -3, 4, -1, 2, 1, -5, 4],
//the contiguous subarray[4, -1, 2, 1] has the largest sum = 6.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
using namespace std;

class Solution {
public:
	int maxSubArray(vector<int>& nums) {
		int n = nums.size();

		int sum = 0, ans = nums[0];

		for (int i = 0; i < n; ++i)
		{
			sum += nums[i];
			ans = max(sum, ans);
			sum = max(sum, 0);
		}

		return ans;
	}
};


int main()
{
	vector<int> vec1({ -2, 1, -3, 4, -1, 2, 1, -5, 4 });

	Solution sol1;
	int ret1 = sol1.maxSubArray(vec1);

	/*for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';*/

	system("pause");

	return 0;
}