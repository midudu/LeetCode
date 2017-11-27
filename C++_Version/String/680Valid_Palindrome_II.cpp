//Given a non - empty string s, you may delete at most one character.Judge whether you can make it a palindrome.
//
//Example 1:
//Input: "aba"
//	Output : True
//	Example 2 :
//	Input : "abca"
//	Output : True
//	Explanation : You could delete the character 'c'.
//	Note :
//	The string will only contain lowercase characters a - z.The maximum length of the string is 50000.

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
using namespace std;

class Solution {
public:
	bool validPalindrome(string s)
	{
		int s_length = s.length();

		int low = 0;
		int high = s_length - 1;
		bool flag = true;


		while (low <= high)
		{
			if (s[low] != s[high])
			{
				if (!flag)
					return false;

				flag = false;
				

				if (s[low] == s[high - 1] && s[low + 1] != s[high])
					high--;
				else if (s[low + 1] == s[high] && s[low] != s[high - 1])
					low++;
				else if (s[low + 1] != s[high] && s[low] != s[high - 1])
					return false;
				else
					return validPalindrome_helper(s, low + 1, high) || validPalindrome_helper(s, low, high - 1);
			}
			else
			{
				low++;
				high--;
			}
		}

		return true;
	}

private:
	bool validPalindrome_helper(string s, int low, int high)
	{
		while ( low <= high)
		{
			if (s[low] != s[high])
				return false;
			
			low++;
			high--;
		}

		return true;
	}
};

int main()
{
	Solution sol1;

	string s1("ebcbbececabbacecbbcbe");

	bool receive = sol1.validPalindrome(s1);

	system("pause");

	return 0;
}