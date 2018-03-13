//Given a non - negative integer represented as a non - empty array of digits, plus one to the integer.
//
//You may assume the integer do not contain any leading zero, except the number 0 itself.
//
//The digits are stored such that the most significant digit is at the head of the list.

//9 9 9 9
//
#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
using namespace std;




class Solution {
public:
	vector<int> plusOne(vector<int>& digits) {
		int n = digits.size();

		for (int i = n - 1; i >= 0; --i)
		{
			if (digits[i] == 9)
				digits[i] = 0;
			else
			{
				digits[i]++;
				break;
			}
		}

		if (digits[0] == 0)
		{
			digits[0] = 1;
			digits.push_back(0);
		}

		return digits;
	}
};



int main()
{
	vector<int> number;
	number.push_back(9);
	number.push_back(9);
	number.push_back(9);
	number.push_back(9);
	number.push_back(9);
	number.push_back(9);
	number.push_back(8);

	Solution sol1;
	sol1.plusOne(number);

	for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';

	system("pause");

	return 0;
}