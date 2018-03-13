//Given a non - empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
//
//Example 1:
//Input: "abab"
//
//	Output : True
//
//	Explanation : It's the substring "ab" twice.
//	Example 2 :
//	Input : "aba"
//
//	Output : False
//	Example 3 :
//	Input : "abcabcabcabc"
//
//	Output : True
//
//	Explanation : It's the substring "abc" four times. (And the substring "abcabc" twice.)

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
	bool repeatedSubstringPattern(string s) {
		size_t hp = 1, lp = 0, n = s.size();

		vector<int> dp(n + 1, 0);

		while (hp < s.size()) //j = 0, i = 1
		{
			if (s[hp] == s[lp])
			{
				++hp;
				++lp;
				dp[hp] = lp;
			}
			else if (lp == 0) 
				hp++;
			else 
				lp = dp[lp];
		}

		return dp[n] && dp[n] % (n - dp[n]) == 0;
	}
};

int main()
{
	Solution sol1;

	string A("ababab"), B("baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba");

	bool receive = sol1.repeatedSubstringPattern(A);

	system("pause");

	return 0;
}