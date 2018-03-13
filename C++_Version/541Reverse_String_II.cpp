//Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.If there are less than k characters left, reverse all of them.If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
//Example:
//Input: s = "abcdefg", k = 2
//	Output : "bacdfeg"
//	Restrictions :
//	The string consists of lower English letters only.
//	Length of the given string and k will in the range[1, 10000]

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
using namespace std;


class Solution {
public:
	string reverseStr(string s, int k) {
		int length = s.length();

		for (int i = 0; i < (length / k / 2); ++i)
		{
			int start = 2 * i * k;
			int end = (2 * i + 1) * k;

			reverse(s.begin()+start, s.begin() + end);
		}

		int left = length - (length / k / 2) * 2 * k;

		if (left > 0)
		{
			if (left <= k)
				reverse(s.end() - left, s.end());
			else
				reverse(s.end() - left, s.end() - left + k);
		}
		
		return s;
	}
};

int main()
{
	string string1 = "hello darkness my old friend", string2 = "el";

	Solution sol1;

	string receive_value = sol1.reverseStr(string1, 2);

	cout << receive_value << endl;

	system("pause");

	return 0;
}