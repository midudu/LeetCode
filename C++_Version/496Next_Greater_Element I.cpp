//You are given two arrays(without duplicates) nums1 and nums2 where nums1¡¯s elements are subset of nums2.Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//
//The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.If it does not exist, output - 1 for this number.
//
//Example 1:
//Input: nums1 = [4, 1, 2], nums2 = [1, 3, 4, 2].
//	Output : [-1, 3, -1]
//	Explanation :
//	For number 4 in the first array, you cannot find the next greater number for it in the second array, so output - 1.
//	For number 1 in the first array, the next greater number for it in the second array is 3.
//	For number 2 in the first array, there is no next greater number for it in the second array, so output - 1.
//	Example 2 :
//	Input : nums1 = [2, 4], nums2 = [1, 2, 3, 4].
//	Output : [3, -1]
//	Explanation :
//	For number 2 in the first array, the next greater number for it in the second array is 3.
//	For number 4 in the first array, there is no next greater number for it in the second array, so output - 1.
//	Note :
//	All elements in nums1 and nums2 are unique.
//	The length of both nums1 and nums2 would not exceed 1000.

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
	vector<int> nextGreaterElement(vector<int>& findNums, vector<int>& nums) {
		int length_nums = nums.size(), length_findNums = findNums.size();

		stack<int> temp;

		unordered_map<int, int> storage;

		for (int i = 0; i < length_nums; ++i)
		{
			while (!temp.empty() && temp.top() < nums[i])
			{
				storage[temp.top()] = nums[i];
				temp.pop();
			}
		
			temp.push(nums[i]);
		}


		vector<int> output;
		for (int i = 0; i < length_findNums; ++i)
		{
			output.push_back(storage.count(findNums[i]) ? storage[findNums[i]] : -1);
		}

		return output;
	}
};


int main()
{
	vector<int> a1({ 4,1,2 });
	vector<int> a2({ 1,3,4,2 });


	Solution sol1;

	vector<int> receive = sol1.nextGreaterElement(a1, a2);

	system("pause");

	return 0;
}