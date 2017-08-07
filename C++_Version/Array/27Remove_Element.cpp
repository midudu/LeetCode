//Given an array and a value, remove all instances of that value in place and return the new length.
//
//Do not allocate extra space for another array, you must do this in place with constant memory.
//
//The order of elements can be changed.It doesn't matter what you leave beyond the new length.
//
//Example:
//Given input array nums = [3, 2, 2, 3], val = 3
//
//Your function should return length = 2, with the first two elements of nums being 2.


#include <vector>
#include <iostream>
#include <cstdlib>
using namespace std;


class Solution {
public:
	int removeElement(vector<int>& nums, int val) {
		int count = 0;

		for (int i = 0; i < (int)nums.size(); ++i)
		{                                    //3 2 2 3
			if (nums[i] == val)
				count++;
			else
				nums[i - count] = nums[i];
		}

		while (count > 0)
		{
			count--;
			nums.pop_back();
		}

		return (int)nums.size();
	}
};



int main()
{
	vector<int> number;
	number.push_back(1);
	number.push_back(6);
	number.push_back(6);
	number.push_back(7);
	number.push_back(7);

	Solution sol1;
	int num = sol1.removeElement(number,7);


	for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';

	system("pause");

	return 0;
}