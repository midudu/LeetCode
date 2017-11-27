//The count - and-say sequence is the sequence of integers with the first five terms as following :
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth term of the count - and-say sequence.
//
//Note: Each term of the sequence of integers will be represented as a string.
//
//	Example 1 :
//
//	Input : 1
//	Output : "1"
//	Example 2 :
//
//	Input : 4
//	Output : "1211"

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
	string countAndSay(int n) {
		if (0 == n) 
			return "";
		if (1 == n) 
			return "1";

		std::string res = "1";
		std::string s;

		for (int i = 1; i < n; i++) 
		{    // run from starting to generate second string

			int len = res.size();

			//cheack all digits in the string
			for (int j = 0; j < len; j++) 
			{

				int count = 1; // we have at least 1 occourence of each digit

							   // get the number of times same digit occurred (be carefull with the end of the string)
				while ((j + 1 < len) && (res[j] == res[j + 1])) {
					count++;
					j++;        // we need to keep increasing the index inside of the string
				}

				// add to new string "count"+"digit itself"
				s += std::to_string(count) + res[j];
			}

			// save temporary result
			res = s;

			// clean our string-helper
			s.clear();

		}

		return res;
	}
};

int main()
{
	Solution sol1;

	string A(" Hello,   my name is John ");

	string receive = sol1.countAndSay(5);

	system("pause");

	return 0;
}