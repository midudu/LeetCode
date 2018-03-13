//Given a roman numeral, convert it to an integer.
//
//Input is guaranteed to be within the range from 1 to 3999.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <unordered_map>
using namespace std;


class Solution {
public:
	int romanToInt(string s) {
		int length = s.length();

		if (length == 0)
			return 0;

		unordered_map<char, int> map1 = {
			{ 'I' , 1 },
			{ 'V' , 5 },
			{ 'X' , 10 },
			{ 'L' , 50 },
			{ 'C' , 100 },
			{ 'D' , 500 },
			{ 'M' , 1000 }
		};

		int sum = map1[s.back()];

		for (int i = length - 2; i >= 0; --i)
		{
			if (map1[s[i]] < map1[s[i + 1]])
				sum -= map1[s[i]];
			else
				sum += map1[s[i]];
		}

		return sum;
	}
};

int main()
{
	string string1 = "XCVIII", string2 = "el";

	Solution sol1;

	int receive_value = sol1.romanToInt(string1);

	cout << receive_value << endl;

	system("pause");

	return 0;
}