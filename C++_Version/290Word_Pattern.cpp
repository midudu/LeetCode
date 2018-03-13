//Given a pattern and a string str, find if str follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non - empty word in str.
//
//Examples:
//pattern = "abba", str = "dog cat cat dog" should return true.
//pattern = "abba", str = "dog cat cat fish" should return false.
//pattern = "aaaa", str = "dog cat cat dog" should return false.
//pattern = "abba", str = "dog dog dog dog" should return false.
//Notes :
//	You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
	bool wordPattern(string pattern, string str) 
	{
		int str_length = (int)str.length();
		string::iterator start_iter = str.begin();
		vector<string> str_slice;
		string temp;

		for (string::iterator iter = str.begin(); iter!= str.end(); )
		{
			if ( *iter == ' ')
			{
				temp.assign(start_iter, iter);
				str_slice.push_back(temp);
				iter++;
				start_iter = iter;
			}
			iter++;
		}
		temp.assign(start_iter, str.end());
		str_slice.push_back(temp);

		if ((int)str_slice.size() != (int)pattern.length())
			return false;

		unordered_map<char, string> c2s;
		unordered_map<string, char> s2c;

		for (int i = 0; i < (int)pattern.length(); ++i)
		{
			if (c2s[pattern[i]] == "")
				c2s[pattern[i]] = str_slice[i];
			else if (c2s[pattern[i]] != str_slice[i])
				return false;

			if (s2c[str_slice[i]] == 0)
				s2c[str_slice[i]] = pattern[i];
			else if (s2c[str_slice[i]] != pattern[i])
				return false;
		}
		return true;
	}
};


int main()
{
	Solution sol1;
	string pattern = "abba", str = "dog cat cat dog";

	bool receive_flag = sol1.wordPattern(pattern, str);

	system("pause");

	return 0;
}