//Write a function to find the longest common prefix string amongst an array of strings.

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
	string longestCommonPrefix(vector<string>& strs) {
		int size = strs.size();

		string temp_string;

		if (size == 0)
			return temp_string;
		else if (size == 1)
			return strs[0];

		int length = strs[0].length();

		
		for (int i = 0; i < length; ++i)
		{
			for (int j = 1; j < size; ++j)
			{
				if (strs[j][i] != strs[0][i])
				{
					if (i != 0)
						return strs[0].substr(0, i);
					else
						return temp_string;
				}
			}
		}
		
		return strs[0];
	}
};

int main()
{
	string string1 = "XCVIII", string2 = "el";

	vector<string> strs;

	strs.push_back("aa");
	strs.push_back("ab");

	Solution sol1;
	string receive_value = sol1.longestCommonPrefix(strs);

	cout << receive_value << endl;

	system("pause");

	return 0;
}