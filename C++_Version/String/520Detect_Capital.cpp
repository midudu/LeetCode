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

		if (isupper(word[0]))    //����ĸ��д
		{
			if (isupper(word[1]))    //�ڶ�����ĸҲ��д�Ļ���������ĸ��Ӧ���Ǵ�д
			{
				for (int i = 2; i < length; ++i)
				{
					if (islower(word[i]))
						return false;
				}
			}
			else           //�ڶ�����ĸ��Сд�Ļ�������ĸ�����������ĸ��Ӧ����Сд
			{
				for (int i = 2; i < length; ++i)
				{
					if (isupper(word[i]))
						return false;
				}
			}
		}             //����ĸСд����������ĸ��Ӧ����Сд
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