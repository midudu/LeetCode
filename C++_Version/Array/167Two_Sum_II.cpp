//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//
//The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.Please note that your returned answers(both index1 and index2) are not zero - based.
//
//You may assume that each input would have exactly one solution and you may not use the same element twice.
//
//Input: numbers = { 2, 7, 11, 15 }, target = 9
//	Output : index1 = 1, index2 = 2


#include <vector>
#include <iostream>
#include <cstdlib>
using namespace std;


class Solution {
public:
	vector<int> twoSum(vector<int>& numbers, int target) 
	{
		int low_index = 0, high_index = (int)numbers.size() - 1;
		int temp;

		while (high_index > low_index)
		{
			temp = numbers[low_index] + numbers[high_index];

			if (temp > target)
				high_index--;
			else if (temp < target)
				low_index++;
			else
			{
				low_index++;
				high_index++;
				vector<int> ret({ low_index,high_index });
				return ret;
			}
		}
	}
};



int main()
{
	vector<int> number;
	number.push_back(1);
	number.push_back(3);
	number.push_back(7);
	number.push_back(9);
	number.push_back(12);

	Solution sol1;
	vector<int> temp = sol1.twoSum(number,16);

	for (int i = 0; i < (int)temp.size(); ++i)
		cout << temp[i] << ' ';

	system("pause");

	return 0;
}