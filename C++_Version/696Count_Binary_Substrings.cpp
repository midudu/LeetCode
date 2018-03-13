//Give a string s, count the number of non - empty(contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
//
//Substrings that occur multiple times are counted the number of times they occur.
//
//Example 1:
//Input: "00110011"
//	Output : 6
//	Explanation : There are 6 substrings that have equal number of consecutive 1's and 0's : "0011", "01", "1100", "10", "0011", and "01".
//
//	Notice that some of these substrings repeat and are counted the number of times they occur.
//
//	Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
//	Example 2:
//   Input: "10101"
//	   Output : 4
//	   Explanation : There are 4 substrings : "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
//	   Note :
//
//	   s.length will be between 1 and 50, 000.
//	   s will only consist of "0" or "1" characters.

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
using namespace std;

class Solution {
public:
	int countBinarySubstrings(string s) {
		int size = s.size();
		vector<int> storage;
		int count = 1;
		for (int i = 1; i < size ; ++i)
		{
			if (s[i] == s[i - 1])
			{
				count++;
			}
			else
			{
				storage.push_back(count);
				count = 1;
			}
		}
		storage.push_back(count);

		size_t storage_size = storage.size();
		int result = 0;
		for (size_t i = 1; i < storage_size; i++)
		{
			result += std::min(storage[i], storage[i - 1]);
		}

		return result;
	}
};

int main()
{
	Solution sol1;

	string s("10101");

	int receive = sol1.countBinarySubstrings(s);

	system("pause");

	return 0;
}