//Suppose you have a long flowerbed in which some of the plots are planted and some are not.However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
//
//Given a flowerbed(represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no - adjacent - flowers rule.
//
//Example 1:
//Input: flowerbed = [1, 0, 0, 0, 1], n = 1
//	Output : True
//	Example 2 :
//	Input : flowerbed = [1, 0, 0, 0, 1], n = 2
//	Output : False
//	Note :
//	   The input array won't violate no-adjacent-flowers rule.
//		   The input array size is in the range of[1, 20000].
//		   n is a non - negative integer which won't exceed the input array size.

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
	bool canPlaceFlowers(vector<int>& flowerbed, int n) {
		if (n == 0)
			return true;

		int flowerbed_size = (int)flowerbed.size();
		if (flowerbed_size == 1)
		{
			if (flowerbed[0] == 1 || n > 1)
				return false;
			else
				return true;
		}


		int unfinished = n;

		if (flowerbed[0] == 0 && flowerbed_size > 1 && flowerbed[1] == 0)
		{
			unfinished--;
			if (unfinished == 0)
				return true;

			flowerbed[0] = 1;
		}
		
		for (int i = 1; i < flowerbed_size - 1; i++)
		{
			if (flowerbed[i] == 0)
			{
				if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)
				{
					unfinished--;
					if (unfinished == 0)
						return true;

					flowerbed[i] = 1;
				}
			}
		}

		if (flowerbed[flowerbed_size - 1] == 0 && flowerbed_size > 1 && flowerbed[flowerbed_size - 2] == 0)
		{
			unfinished--;
			if (unfinished == 0)
				return true;
		}

		return false;
	}
};

int main()
{
	Solution sol1;
	
	vector<vector<int>> nums1 = { {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
	{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
	{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
	{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0} };

	int receive = sol1.maxAreaOfIsland(nums1);

	system("pause");

	return 0;
}