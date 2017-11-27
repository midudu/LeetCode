//Write a function that takes a string as input and reverse only the vowels of a string.
//
//Example 1:
//Given s = "hello", return "holle".
//
//Example 2 :
//	Given s = "leetcode", return "leotcede".

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
	string reverseVowels(string s) {
		size_t s_length = s.length();

		if (s_length <= 1)
			return s;

		unordered_set<char> vowels;
		vowels.insert('a');
		vowels.insert('e');
		vowels.insert('i');
		vowels.insert('o');
		vowels.insert('u');
		vowels.insert('A');
		vowels.insert('E');
		vowels.insert('I');
		vowels.insert('O');
		vowels.insert('U');

		
		int l_p = 0, h_p = s_length - 1;

		while (l_p < h_p)
		{
			while (l_p < h_p && vowels.find(s[l_p]) == vowels.end())
				l_p++;
 			while (l_p < h_p && vowels.find(s[h_p]) == vowels.end())
				h_p--;

			char temp = s[l_p];
			s[l_p] = s[h_p];
			s[h_p] = temp;

			l_p++;
			h_p--;
		}

		return s;
	}
};

int main()
{
	Solution sol1;

	string A("a."), B("baaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbababaaabbbaba");

	string receive = sol1.reverseVowels(A);

	system("pause");

	return 0;
}