//Given a word, you need to judge whether the usage of capitals in it is right or not.
//
//We define the usage of capitals in a word to be right when one of the following cases holds :
//
//All letters in this word are capitals, like "USA".
//All letters in this word are not capitals, like "leetcode".
//Only the first letter in this word is capital if it has more than one letter, like "Google".
//Otherwise, we define that this word doesn't use capitals in a right way.
//Example 1:
//Input: "USA"
//	Output : True
//	Example 2 :
//	Input : "FlaG"
//	Output : False
//	Note : The input will be a non - empty word consisting of uppercase and lowercase latin letters.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <unordered_map>
using namespace std;


class Solution {
public:
	bool detectCapitalUse(string word) {
		int length = word.length();

		if (length < 2)
			return true;

		if (isupper(word[0]))    //首字母大写
		{
			if (isupper(word[1]))    //第二个字母也大写的话，所有字母都应该是大写
			{
				for (int i = 2; i < length; ++i)
				{
					if (islower(word[i]))
						return false;
				}
			}
			else           //第二个字母是小写的话，首字母以外的所有字母都应该是小写
			{
				for (int i = 2; i < length; ++i)
				{
					if (isupper(word[i]))
						return false;
				}
			}
		}             //首字母小写，则所有字母都应该是小写
		else
		{
			for (int i = 1; i < length; ++i)
			{
				if (isupper(word[i]))
					return false;
			}
		}

		return true;
	}
};

int main()
{
	string string1 = "XCVIII", string2 = "el";

	Solution sol1;

	bool receive_value = sol1.detectCapitalUse(string2);

	cout << receive_value << endl;

	system("pause");

	return 0;
}