//Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//Example 1:
//Input: "Let's take LeetCode contest"
//	Output : "s'teL ekat edoCteeL tsetnoc"
//	Note : In the string, each word is separated by single space and there will not be any extra space in the string.

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
	string reverseWords(string s) {

		int length = s.length();
		int start = 0;

		for (int i = 0; i < length; ++i)
		{
			if (s[i] == ' ')
			{
				reverse(s.begin() + start, s.begin() + i);
				start = i + 1;
			}
			if (i == length - 1)
				reverse(s.begin() + start, s.end());
		}

		return s;
	}
};

int main()
{
	string string1 = "hello darkness my old friend", string2 = "el";

	Solution sol1;

	string receive_value = sol1.reverseWords(string1);

	cout << receive_value << endl;

	system("pause");

	return 0;
}