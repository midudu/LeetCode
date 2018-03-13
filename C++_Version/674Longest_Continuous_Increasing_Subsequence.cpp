//Given an unsorted array of integers, find the length of longest continuous increasing subsequence.
//
//Example 1:
//Input: [1, 3, 5, 4, 7]
//	Output : 3
//	Explanation : The longest continuous increasing subsequence is[1, 3, 5], its length is 3.
//	Even though[1, 3, 5, 7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
//	Example 2 :
//	Input : [2, 2, 2, 2, 2]
//	Output : 1
//	Explanation : The longest continuous increasing subsequence is[2], its length is 1.

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
	int findLengthOfLCIS(vector<int>& nums) {
		if ((int)nums.size() <= 1)
			return (int)nums.size();
		
		int result = 1;
		int temp = 1;

		for (int i = 1; i < (int)nums.size(); ++i)
		{
			if (nums[i] > nums[i - 1])
				temp++;
			else
			{
				if (temp > result)
					result = temp;

				temp = 1;
			}
		}
		if (temp > result)
			result = temp;

		return result;
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