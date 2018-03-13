//Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non - space characters.
//
//Please note that the string does not contain any non - printable characters.
//
//Example:
//
//Input: "Hello, my name is John"
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
	int countSegments(string s) {
		int start = s.find_first_not_of(' ');
		if (start == -1)
			return 0;

		int end = s.find_last_not_of(' ');

		int count = 0, index = 0;

		while (start <= end)
		{
			count++;

			index = s.find_first_of(' ', start);
			if (index == -1 || index > end)
				return count;

			start = s.find_first_not_of(' ', index);
		}

		return count;
	}
};

int main()
{
	Solution sol1;

	string A(" Hello,   my name is John ");

	int receive = sol1.countSegments(A);

	system("pause");

	return 0;
}