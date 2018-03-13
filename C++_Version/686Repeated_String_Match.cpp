//Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it.If no such solution, return -1.
//
//For example, with A = "abcd" and B = "cdabcdab".
//
//Return 3, because by repeating A three times(“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times("abcdabcd").
//
//Note:
//The length of A and B will be between 1 and 10000.

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
	int repeatedStringMatch(string A, string B) {
		size_t A_length = A.length();
		size_t B_length = B.length();

		string A_append = A;
		size_t A_append_length = A_length;

		while (A_append_length < B_length)
		{
			A_append.append(A);
			A_append_length += A_length;
		}

		if (KMP(B, A_append))
			return int(A_append.length() / A.length());

		A_append.append(A);
		if (KMP(B, A_append))
			return int(A_append.length() / A.length());
		else
			return -1;
	}

private:
	bool KMP(string pattern, string target)
	{
		size_t pattern_length = pattern.length();
		size_t target_length = target.length();

		vector<int> function(pattern_length, 0);
		function[0] = -1;
		for (size_t i = 1; i < pattern_length; i++)
		{
			int k = function[i - 1];
			while (k >= 0)
			{
				if (pattern[k] == pattern[i])
					break;
				else
					k = function[k];
			}
			function[i] = k + 1;
		}

		for (size_t i = 0, k = 0; i < target_length; )
		{
			if (k == -1)
			{
				k = 0;
				i++;
			}
			else if (target[i] == pattern[k])
			{
				i++;
				k++;
				if (k == pattern_length)
					return true;
			}
			else
			{
				k = function[k];
			}
		}

		return false;
	}
};

int main()
{
	Solution sol1;

	string A("baaabbbaba"), B("baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba");

	int receive = sol1.repeatedStringMatch(A, B);

	system("pause");

	return 0;
}