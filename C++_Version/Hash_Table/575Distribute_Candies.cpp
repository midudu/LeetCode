//Given an integer array with even length, where different numbers in this array represent different kinds of candies.Each number means one candy of the corresponding kind.You need to distribute these candies equally in number to brother and sister.Return the maximum number of kinds of candies the sister could gain.
//
//Example 1:
//Input: candies = [1, 1, 2, 2, 3, 3]
//	Output : 3
//	Explanation :
//	There are three different kinds of candies(1, 2 and 3), and two candies for each kind.
//	Optimal distribution : The sister has candies[1, 2, 3] and the brother has candies[1, 2, 3], too.
//	The sister has three different kinds of candies.
//	Example 2 :
//	Input : candies = [1, 1, 2, 3]
//	Output : 2
//	Explanation : For example, the sister has candies[2, 3] and the brother has candies[1, 1].
//	The sister has two different kinds of candies, the brother has only one kind of candies.
//	Note :
//
//	The length of the given array is in range[2, 10, 000], and will be even.
//	The number in given array is in range[-100, 000, 100, 000].


#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <queue>
#include <unordered_map>
using namespace std;


class Solution {
public:
	int distributeCandies(vector<int>& candies) {
		
		unordered_map<int, int> storage;
		int candies_size = candies.size();

		for (int i = 0; i < candies_size; ++i)
		{
			storage[candies[i]]++;
		}

		if (storage.size() >= candies_size / 2)
			return candies_size / 2;
		else
			return storage.size();
	}
};

int main()
{
	vector<int> list1({ 1, 1, 2, 2, 3, 3 });
	vector<string> list2({ "KFC", "Shogun", "Burger King" });

	Solution sol1;

	int receive = sol1.distributeCandies(list1);

	system("pause");

	return 0;
}