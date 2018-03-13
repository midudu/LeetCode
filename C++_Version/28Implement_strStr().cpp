//Implement strStr().

//Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
using namespace std;


class Solution {
public:
	int strStr(string haystack, string needle) {
		int length_h = haystack.length(), length_n = needle.length();
		bool flag = true;

		if (length_n == 0)
			return 0;

		for (int i = 0; i <= length_h - length_n; ++i)
		{
			flag = true;
			for (int j = 0; j < length_n; ++j)
			{
				if (haystack[i + j] != needle[j])
				{
					flag = false;
					break;
				}
					
			}
			if (flag)
				return i;
		}

		return -1;
	}
};

int main()
{
	string string1 = "hello", string2 = "el";

	Solution sol1;

	int receive_value = sol1.strStr(string2, string1);

	cout << receive_value;

	system("pause");

	return 0;
}