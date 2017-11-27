//Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines; otherwise, it will return false.
//
//Each letter in the magazine string can only be used once in your ransom note.
//
//Note:
//You may assume that both strings contain only lowercase letters.
//
//canConstruct("a", "b") -> false
//canConstruct("aa", "ab") -> false
//canConstruct("aa", "aab") -> true

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
	bool canConstruct(string ransomNote, string magazine) {
		unordered_map<char, int> storage;

		for (string::iterator iter = magazine.begin(); iter != magazine.end(); iter++)
		{
			storage[*iter]++;
		}

		for (string::iterator iter = ransomNote.begin(); iter != ransomNote.end(); iter++)
		{
			storage[*iter]--;
			if (storage[*iter] < 0)
				return false;
		}

		return true;
	}
};

int main()
{
	Solution sol1;

	string A("aa"), B("ab");

	bool receive = sol1.canConstruct(A,B);

	system("pause");

	return 0;
}