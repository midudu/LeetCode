//Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//For example,
//Given input array nums = [1, 1, 2],
//
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//It doesn't matter what you leave beyond the new length.


#include <vector>
#include <iostream>
#include <cstdlib>
using namespace std;


class Solution {
public:
	int removeDuplicates(vector<int>& nums) 
	{
		if ((int)nums.size() == 1)
			return 1;

		else
		{
			int duplicate_count = 0;

			for (int i = 1; i < (int)nums.size(); ++i)
			{
				if (nums[i] == nums[i - 1])
					duplicate_count++;
				else
					nums[i - duplicate_count] = nums[i];
			}
			//1,2,3,3,3,4,4,5,7,7,8

			if (duplicate_count != 0)
			{
				for (int i = 0; i < duplicate_count; ++i)
				{
					nums.pop_back();
				}
			}

			return (int)nums.size();
		}
	}
};



int main()
{
	vector<int> number;
	number.push_back(1);
	number.push_back(1);
	//number.push_back(3);
	//number.push_back(3);
	//number.push_back(12);

	Solution sol1;
	int num = sol1.removeDuplicates(number);


	for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';

	system("pause");

	return 0;
}