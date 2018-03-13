//Given a non - empty array of non - negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
//
//Your task is to find the smallest possible length of a(contiguous) subarray of nums, that has the same degree as nums.
//
//Example 1:
//Input: [1, 2, 2, 3, 1]
//	Output : 2
//	Explanation :
//	The input array has a degree of 2 because both elements 1 and 2 appear twice.
//	Of the subarrays that have the same degree :
//	   [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//		   The shortest length is 2. So return 2.
//		   Example 2 :
//		   Input : [1, 2, 2, 3, 1, 4, 2]
//		   Output : 6

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
	int findShortestSubArray(vector<int>& nums) {
		map<int, int> frequecy;

		for (int i = 0; i < (int)nums.size(); ++i)
		{
			frequecy[nums[i]]++;
		}

		int max_frequency = 0;
		vector<int> max_frequency_numbers;

		for (map<int, int>::iterator iter = frequecy.begin(); iter != frequecy.end(); iter++)
		{
			if (iter->second > max_frequency)
			{
				vector<int>().swap(max_frequency_numbers);
				max_frequency_numbers.push_back(iter->first);
				max_frequency = iter->second;
			}
			else if (iter->second == max_frequency)
			{
				max_frequency_numbers.push_back(iter->first);;
			}
		}

		int result = (int)nums.size();
		int num;
		int position1, position2;
		
		for (int i = 0; i < (int)max_frequency_numbers.size(); ++i)
		{
			num = max_frequency_numbers[i];

			for (int j = 0; j < (int)nums.size(); ++j)
			{
				if (nums[j] == num)
				{
					position1 = j;
					break;
				}
			}
			for (int j = (int)nums.size() - 1; j >= 0; --j)
			{
				if (nums[j] == num)
				{
					position2 = j;
					break;
				}
			}

			if (position2 - position1 + 1 < result)
				result = position2 - position1 + 1;
		}

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