//Rotate an array of n elements to the right by k steps.
//
//For example, with n = 7 and k = 3, the array[1, 2, 3, 4, 5, 6, 7] is rotated to[5, 6, 7, 1, 2, 3, 4].


#include <vector>
#include <iostream>
#include <cstdlib>
using namespace std;


class Solution {
public:
	void rotate(vector<int>& nums, int k) {
		int n = nums.size();      //7
		k = k % n;
		int m = n - k;            //4
		
		for (int i = 0; i < m; ++i)
		{
			nums.push_back(nums[i]);
		}

		vector<int>::iterator iter1 = nums.begin();

		while (m > 0)
		{
			iter1 = nums.erase(iter1);

			m--;
		}
	}
};



int main()
{
	vector<int> number;
	number.push_back(1);
	number.push_back(2);
	number.push_back(3);
	number.push_back(4);
	number.push_back(5);
	number.push_back(6);
	number.push_back(7);

	Solution sol1;
	sol1.rotate(number,3);


	for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';

	system("pause");

	return 0;
}