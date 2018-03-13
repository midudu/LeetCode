//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be[1, 3, 12, 0, 0].
//
//Note:
//You must do this in - place without making a copy of the array.
//Minimize the total number of operations.

#include <vector>
#include <iostream>
#include <cstdlib>
using namespace std;

class Solution {
public:
	void moveZeroes(vector<int>& nums) 
	{
		int zero_count = 0;

		for (int i = 0; i < (int)nums.size(); ++i)
		{
			if (nums[i] == 0)
				zero_count++;
			else
				nums[i - zero_count] = nums[i];
		}
		for (int j = nums.size() - zero_count; j < (int)nums.size(); ++j)
			nums[j] = 0;
	}
};



int main()
{
	vector<int> number;
	number.push_back(0);
	number.push_back(1);
	number.push_back(0);
	number.push_back(3);
	number.push_back(12);

	Solution sol1;
	sol1.moveZeroes(number);

	for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';

	system("pause");

	return 0;
}