//Given an array of integers where 1 ¡Ü a[i] ¡Ü n(n = size of array), some elements appear twice and others appear once.
//
//Find all the elements of[1, n] inclusive that do not appear in this array.
//
//Could you do it without extra space and in O(n) runtime ? You may assume the returned list does not count as extra space.
//
//Example :
//
//	Input :
//		  [4, 3, 2, 7, 8, 2, 3, 1]
//
//Output :
//	[5, 6]



#include <vector>
#include <iostream>
#include <cstdlib>
using namespace std;

class Solution {
public:
	vector<int> findDisappearedNumbers(vector<int>& nums);
};

vector<int> Solution::findDisappearedNumbers(vector<int>& nums)
{
	int size = nums.size();

	int i,m;
	for (i = 0; i < size; ++i)
	{
		m = abs(nums[i]) - 1;

		nums[m] = (nums[m] < 0 ? nums[m] : -nums[m]);
	}


	vector<int> result;
	for (i = 0; i < size; ++i)
	{
		if (nums[i]>0)
			result.push_back(i + 1);
	}

	return result;
}


int main()
{
	int input_array[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
	int size = sizeof(input_array) / sizeof(input_array[0]);

	vector<int> input_vector(input_array, input_array + size);

	Solution solution_main;

	vector<int> output_vector = solution_main.findDisappearedNumbers(input_vector);


	for (int i = 0; i < output_vector.size(); ++i)
	{
		cout << output_vector[i] << endl;
	}
	
	system("pause");

	return 0;
}