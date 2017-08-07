//Given a non - empty array of integers, return the third maximum number in this array.
//If it does not exist, return the maximum number.The time complexity must be in O(n).
//
//Example 1:
//Input: [3, 2, 1]
//Output : 1
//Explanation : The third maximum is 1.

//Example 2 :
//Input : [1, 2]
//	Output : 2
//	Explanation : The third maximum does not exist, so the maximum(2) is returned instead.

//	Example 3 :
//	Input : [2, 2, 3, 1]
//
//	Output : 1
//
//	Explanation : Note that the third maximum here means the third maximum distinct number.
//	Both numbers with value 2 are both considered as second maximum.

#include <vector>
#include <iostream>
#include <cstdlib>
using namespace std;

class Solution {
public:
	int thirdMax(vector<int>& nums)
	{
		int a = nums[0], b = nums[0], c = nums[0];
		bool second_flag = false, third_flag = false;

		for (int i = 0; i < (int)nums.size(); ++i)
		{
			if ( nums[i] == a || nums[i] == b || nums[i] == c )
				continue;
			else
			{
				if (!second_flag)
				{
					second_flag = true;

					if (nums[i] > a)
					{
						b = a;
						a = nums[i];
					}
					else
					{
						b = nums[i];
					}
				}
				else
				{
					if (!third_flag)
					{
						third_flag = true;

						if (nums[i] > a)
						{
							c = b;
							b = a;
							a = nums[i];
						}
						else if (nums[i] > b)
						{
							c = b;
							b = nums[i];
						}
						else
							c = nums[i];
					}
					else
					{
						if (nums[i] > a)
						{
							c = b;
							b = a;
							a = nums[i];
						}
						else if (nums[i] > b)
						{
							c = b;
							b = nums[i];
						}
						else if (nums[i] > c)
							c = nums[i];
					}
				}
			}
		}

		return (third_flag ? c : a);
	}
};



int main()
{
	vector<int> number;
	number.push_back(1);
	number.push_back(2);
	//number.push_back(1);
	//number.push_back(7);                  //2 2 3 1

	Solution sol1;
	int exact_number = sol1.thirdMax(number);

	cout << exact_number << endl;

	system("pause");

	return 0;
}