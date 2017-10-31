//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
//
//Note:
//You may assume that nums1 has enough space(size that is greater or equal to m + n) to hold additional elements from nums2.The number of elements initialized in nums1 and nums2 are m and n respectively.

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
	void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) 
	{
		if (nums1.empty())
		{
			nums1 = nums2;
			return;
		}
		if (nums2.empty())
			return;

		int nums1_pointer = 0, nums2_pointer = 0;
		vector<int> storage;

		while (nums1_pointer!=m && nums2_pointer !=n)
		{
			if (nums1[nums1_pointer] <= nums2[nums2_pointer])
			{
				storage.push_back(nums1[nums1_pointer]);
				nums1_pointer++;
			}
			else
			{
				storage.push_back(nums2[nums2_pointer]);
				nums2_pointer++;
			}
		}

		if (nums1_pointer == m)
		{
			for ( int i = nums2_pointer; i < n; ++i)
				storage.push_back(nums2[i]);
		}
		else if (nums2_pointer == n)
		{
			for (int i = nums1_pointer; i < m; ++i)
				storage.push_back(nums1[i]);
		}

		nums1 = storage;
	}
};


int main()
{
	Solution sol1;
	
	vector<int> nums1({ 1,2,3,3,4,5,6 });
	vector<int> nums2({ 1,2,3,4,4,5,6,7,8 });

	sol1.merge(nums1, (int)nums1.size(), nums2, (int)nums2.size());

	system("pause");

	return 0;
}