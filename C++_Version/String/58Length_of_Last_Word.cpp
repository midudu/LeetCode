//Given a string s consists of upper / lower - case alphabets and empty space characters ' ', return the length of last word in the string.
//
//If the last word does not exist, return 0.
//
//Note: A word is defined as a character sequence consists of non - space characters only.
//
//	Example :
//
//	Input : "Hello World"
//	Output : 5

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
	int lengthOfLastWord(string s) {
		if (s.empty())
			return 0;

		int index_1 = s.find_last_not_of(' ');
		if (index_1 == -1)
			return 0;

		int index_2 = s.find_last_of(' ', index_1);

		return (index_1 - index_2);
	}
};

int main()
{
	Solution sol1;

	string A("World"), B("baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba");

	int receive = sol1.lengthOfLastWord(A);

	system("pause");

	return 0;
}