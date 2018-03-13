//Initially, there is a Robot at position(0, 0).Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
//
//The move sequence is represented by a string.And each move is represent by a character.The valid robot moves are R(Right), L(Left), U(Up) and D(down).The output should be true or false representing whether the robot makes a circle.
//
//Example 1:
//Input: "UD"
//	Output : true
//	Example 2 :
//	Input : "LL"
//	Output : false

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
	bool judgeCircle(string moves) {
		size_t size = moves.size();

		int left_right = 0;
		int up_down = 0;

		for (int i = 0; i < size; ++i)
		{
			switch (moves[i])
			{
			case 'U':
			{
				up_down += 1;
				break;
			}
			case 'D':
			{
				up_down -= 1;
				break;
			}
			case 'L':
			{
				left_right += 1;
				break;
			}
			case 'R':
			{
				left_right -= 1;
				break;
			}
			default:
				break;
			}
		}

		return (left_right == 0 && up_down == 0);
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