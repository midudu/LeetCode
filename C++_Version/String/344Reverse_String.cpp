//Write a function that takes a string as input and returns the string reversed.
//
//Example:
//Given s = "hello", return "olleh".

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
	string reverseString(string s) {
		reverse(s.begin(), s.end());

		return s;
	}
};

int main()
{
	Solution sol1;

	string A("hello"), B("baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba");

	string receive = sol1.reverseString(A);

	system("pause");

	return 0;
}