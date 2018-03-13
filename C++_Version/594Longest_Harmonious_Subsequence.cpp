//We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
//
//Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
//
//Example 1:
//Input: [1, 3, 2, 2, 5, 2, 3, 7]
//	Output : 5
//	Explanation : The longest harmonious subsequence is[3, 2, 2, 2, 3].

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <unordered_map>
#include <map>
using namespace std;

class Solution {
public:
	int findLHS(vector<int>& nums) {
		map<int, int> map1;
		
		int size = (int)nums.size();
		for (int i = 0; i < size; ++i)
		{
			map1[nums[i]]++;
		}

		if ((int)map1.size() <= 1)
			return 0;

		int max = 0;
		map<int, int>::iterator iter1 = map1.begin(), iter2=iter1;
		iter2++;
		int temp;
		
		while( iter2 != map1.end() )
		{
			if (iter2->first - iter1->first == 1)
			{
				temp = iter1->second + iter2->second;
				if (temp > max)
					max = temp;
			}

			iter1++;
			iter2++;
		}

		return max;
	}
};


int main()
{
	Solution sol1;
	string pattern = "abba", str = "dog cat cat dog";
	vector<int> a({ 1,3,2,2,5,2,3,7 });

	int receive_flag = sol1.findLHS(a);

	system("pause");

	return 0;
}