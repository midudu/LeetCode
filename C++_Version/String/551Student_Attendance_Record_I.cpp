//You are given a string representing an attendance record for a student.The record only contains the following three characters :
//
//'A' : Absent.
//'L' : Late.
//'P' : Present.
//A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
//
//You need to return whether the student could be rewarded according to his attendance record.
//
//Example 1 :
//	Input : "PPALLP"
//	Output : True
//	Example 2 :
//	Input : "PPALLL"
//	Output : False

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
using namespace std;


class Solution {
public:
	bool checkRecord(string s) {
		int length = s.length();

		int A_count = 0, L_count = 0;

		for (int i = 0; i < length; ++i)
		{
			if (s[i] == 'A')
			{
				L_count = 0;
				A_count++;
				if (A_count > 1)
					return false;
			}
			else if (s[i] == 'L')
			{
				if (L_count == 2)
					return false;
				L_count++;
			}
			else
				L_count = 0;
		}

		return true;
	}
};

int main()
{
	string string1 = "hello darkness my old friend", string2 = "el";

	Solution sol1;

	string receive_value = sol1.reverseWords(string1);

	cout << receive_value << endl;

	system("pause");

	return 0;
}