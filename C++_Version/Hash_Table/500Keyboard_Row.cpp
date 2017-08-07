//Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
//
//
//American keyboard
//
//
//Example 1:
//Input: ["Hello", "Alaska", "Dad", "Peace"]
//	Output : ["Alaska", "Dad"]
//	Note :
//	You may use one character in the keyboard more than once.
//	You may assume the input string will only contain letters of alphabet.


#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <queue>
#include <unordered_map>
#include <unordered_set>
using namespace std;


class Solution {
public:
	vector<string> findWords(vector<string>& words) {

		unordered_set<char> keyboard_top_row, keyboard_middle_row, keyboard_bottom_row;

		string keyboard_top = "QWERTYUIOPqwertyuiop", keyboard_middle = "ASDFGHJKLasdfghjkl", keyboard_bottom = "ZXCVBNMzxcvbnm";

		for (int i = 0; i < (int)keyboard_top.length(); ++i)
			keyboard_top_row.insert(keyboard_top[i]);
		for (int i = 0; i < (int)keyboard_middle.length(); ++i)
			keyboard_middle_row.insert(keyboard_middle[i]);
		for (int i = 0; i < (int)keyboard_bottom.length(); ++i)
			keyboard_bottom_row.insert(keyboard_bottom[i]);


		vector<string> output;
		int words_size = words.size();
		for (int i = 0; i < words_size; ++i)
		{
			bool flag = true;

			int length = words[i].length();

			if (length == 0 || length == 1)
				output.push_back(words[i]);
			else
			{
				if (keyboard_top_row.find(words[i][0]) != keyboard_top_row.end())
				{
					for (int j = 1; j < length; ++j)
					{
						if (keyboard_top_row.find(words[i][j]) == keyboard_top_row.end())
						{
							flag = false;
							break;
						}	
					}
				}
				else if (keyboard_middle_row.find(words[i][0]) != keyboard_middle_row.end())
				{
					for (int j = 1; j < length; ++j)
					{
						if (keyboard_middle_row.find(words[i][j]) == keyboard_middle_row.end())
						{
							flag = false;
							break;
						}
					}
				}
				else if (keyboard_bottom_row.find(words[i][0]) != keyboard_bottom_row.end())
				{
					for (int j = 1; j < length; ++j)
					{
						if (keyboard_bottom_row.find(words[i][j]) == keyboard_bottom_row.end())
						{
							flag = false;
							break;
						}
					}
				}

				if (flag)
					output.push_back(words[i]);
			}
		}

		return output;
	}
};

int main()
{
	vector<int> list1({ 1, 1, 2, 2, 3, 3 });
	vector<string> list2({ "Hello", "Alaska", "Dad", "Peace" });

	Solution sol1;

	vector<string> receive = sol1.findWords(list2);

	system("pause");

	return 0;
}