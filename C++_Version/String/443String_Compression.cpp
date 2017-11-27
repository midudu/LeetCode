//Given an array of characters, compress it in - place.
//
//The length after compression must always be smaller than or equal to the original array.
//
//Every element of the array should be a character(not int) of length 1.
//
//After you are done modifying the input array in - place, return the new length of the array.
//
//
//Follow up :
//Could you solve it using only O(1) extra space ?
//
//
//Example 1 :
//	Input :
//	["a", "a", "b", "b", "c", "c", "c"]
//
//Output :
//	Return 6, and the first 6 characters of the input array should be : ["a", "2", "b", "2", "c", "3"]
//
//	Explanation :
//	"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
//	Example 2 :
//	Input :
//	["a"]
//
//	   Output :
//		   Return 1, and the first 1 characters of the input array should be : ["a"]
//
//		   Explanation :
//		   Nothing is replaced.
//		   Example 3 :
//		   Input :
//		   ["a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"]
//
//			  Output :
//				  Return 4, and the first 4 characters of the input array should be : ["a", "b", "1", "2"].
//
//				  Explanation :
//				  Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
//				  Notice each digit has it's own entry in the array.
//				  Note :
//				  All characters have an ASCII value in[35, 126].
//				  1 <= len(chars) <= 1000.

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
	int compress(vector<char>& chars) 
	{
		int chars_size = chars.size();
		int index_1 = 0, index_2 = 0;
		int count = 0;

		while (index_2 < chars_size)
		{
			char current_char = chars[index_2];
			count = 0;

			while (index_2 < chars_size && chars[index_2] == current_char)
			{
				index_2++;
				count++;
			}
				
			chars[index_1] = current_char;
			index_1++;
			if (count > 1)
			{
				string temp = to_string(count);
				int temp_length = temp.length();
				for (int i = 0; i < temp_length; ++i)
				{
					chars[index_1] = temp[i];
					index_1++;
				}
			}
		}

		while (index_1 < chars_size)
		{
			index_1++;
			chars.pop_back();
		}

		return (int)chars.size();
	}
};

int main()
{
	Solution sol1;

	vector<char> A({ 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' });

	int receive = sol1.compress(A);

	system("pause");

	return 0;
}