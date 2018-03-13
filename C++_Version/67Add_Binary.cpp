//Given two binary strings, return their sum(also a binary string).
//
//For example,
//a = "11"
//b = "1"
//Return "100".

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
	string addBinary(string a, string b) {
		int bit_answer = 0, carry_bit = 0;

		string answer(max(a.length(), b.length()), '0');

		string::reverse_iterator iter_a = a.rbegin(), iter_b = b.rbegin();

		int k = 0;
		for (; iter_a != a.rend() && iter_b != b.rend(); iter_a++, iter_b++,k++)
		{
			bit_answer = (*iter_a - '0') + (*iter_b - '0') + carry_bit;
			answer[k] = '0' + bit_answer % 2;
			carry_bit = bit_answer / 2;
		}

		while (iter_a != a.rend())
		{
			bit_answer = (*iter_a - '0') + carry_bit;
			answer[k] = '0' + bit_answer % 2;
			carry_bit = bit_answer / 2;
			iter_a++;
			++k;
		}
		while (iter_b != b.rend())
		{
			bit_answer = (*iter_b - '0') + carry_bit;
			answer[k] = '0' + bit_answer % 2;
			carry_bit = bit_answer / 2;
			iter_b++;
			++k;
		}

		if (carry_bit == 1)
			answer.append("1");

		reverse(answer.begin(), answer.end());

		return answer;
	}
};

int main()
{
	Solution sol1;

	string A("1111"), B("10");

	string receive = sol1.addBinary(A,B);

	system("pause");

	return 0;
}