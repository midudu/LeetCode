//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <queue>
#include <unordered_map>
using namespace std;


class Solution {
public:
	bool isValid(string s) {
		int length = s.length();
		if (length == 0)
			return true;

		stack<char> repository;

		for (int i = 0; i < length; ++i)
		{
			if (s[i] == '(' || s[i] == '[' || s[i] == '{')
			{
				repository.push(s[i]);
			}
			else 
			{
				if (repository.empty())
					return false;

				switch (s[i])
				{
				case ')':
				{
					if (repository.top() == '(')
						repository.pop();
					else
						return false;
					break;
				}
				case ']':
				{
					if (repository.top() == '[')
						repository.pop();
					else
						return false;
					break;
				}
				case '}':
				{
					if (repository.top() == '{')
						repository.pop();
					else
						return false;
					break;
				}
				default:
					return false;
				}
			}
		}

		if (repository.empty())
			return true;
		else
			return false;
	}
};

int main()
{
	string string1 = "([])";

	Solution sol1;

	cout << sol1.isValid(string1) << endl;

	system("pause");

	return 0;
}