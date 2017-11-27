//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//
//Note:
//Have you consider that the string might be empty ? This is a good question to ask during an interview.
//
//For the purpose of this problem, we define empty string as valid palindrome.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <unordered_map>
#include <map>
#include <set>
#include <unordered_set>
#include <cctype>
using namespace std;

class Solution {
public:
	bool isPalindrome(string s) {
		size_t s_size = s.size();

		vector<char> new_s;

		for (size_t i = 0; i < s_size; ++i)
		{
			if (isalnum(s[i]))
				new_s.emplace_back(std::tolower(s[i]));
		}

		if (new_s.empty())
			return true;

		int begin = 0, end = (int)new_s.size() - 1;

		while (begin <= end)
		{
			if (new_s[begin] != new_s[end])
				return false;

			begin++;
			end--;
		}

		return true;

	}
};

int main()
{
	Solution sol1;

	string s1("race a car");

	bool receive = sol1.isPalindrome(s1);

	system("pause");

	return 0;
}