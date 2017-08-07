//Given a sorted array and a target value, return the index if the target is found.If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Here are few examples.
//[1, 3, 5, 6], 5 ¡ú 2
//[1, 3, 5, 6], 2 ¡ú 1
//[1, 3, 5, 6], 7 ¡ú 4
//[1, 3, 5, 6], 0 ¡ú 0



#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
using namespace std;


class Solution {
public:
	int searchInsert(vector<int>& nums, int target) {
		for (int i = 0; i < (int)nums.size(); ++i)
		{
			if (target <= nums[i])
				return i;
		}
	}
};



int main()
{
	vector<int> number;
	number.push_back(-1);
	number.push_back(-2);
	number.push_back(3);
	number.push_back(6);
	number.push_back(7);
	number.push_back(9);
	number.push_back(12);

	Solution sol1;
	int num = sol1.searchInsert(number,0);


	for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';

	system("pause");

	return 0;
}