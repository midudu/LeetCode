//Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.
//
//You need to help them find out their common interest with the least list index sum.If there is a choice tie between answers, output all of them with no order requirement.You could assume there always exists an answer.
//
//Example 1:
//Input:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//Output : ["Shogun"]
//	Explanation : The only restaurant they both like is "Shogun".
//	Example 2 :
//	Input :
//	["Shogun", "Tapioca Express", "Burger King", "KFC"]
//		 ["KFC", "Shogun", "Burger King"]
//		 Output : ["Shogun"]
//			 Explanation : The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0 + 1).
//			 Note :
//			 The length of both lists will be in the range of[1, 1000].
//			 The length of strings in both lists will be in the range of[1, 30].
//			 The index is starting from 0 to the list length minus 1.
//			 No duplicates in both lists.


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
	vector<string> findRestaurant(vector<string>& list1, vector<string>& list2) {
		unordered_map<string, int> hash_table;

		int size1 = list1.size();
		for (int i = 0; i < size1; ++i)     //°Ñlist1´æµ½hash_tableÖÐ
			hash_table[list1[i]] = i;

		int index_sum = -1;
		int size2 = list2.size();
		vector<string> output;

		for (int i = 0; i < size2; ++i)
		{
			if (index_sum != -1 && i > index_sum)
				break;

			if (hash_table.find(list2[i]) != hash_table.end())
			{
				int temp = i + hash_table[list2[i]];

				if (index_sum == -1)
				{
					index_sum = temp;
					output.push_back(list2[i]);
				}
				else
				{
					if (temp < index_sum)
					{
						index_sum = temp;
						vector<string>().swap(output);
						output.push_back(list2[i]);
					}
					else if (temp == index_sum)
					{
						output.push_back(list2[i]);
					}
				}
			}
		}

		return output;
	}
};

int main()
{
	vector<string> list1({ "Shogun", "Tapioca Express", "Burger King", "KFC" });
	vector<string> list2({ "KFC", "Shogun", "Burger King" });

	Solution sol1;

	vector<string> receive = sol1.findRestaurant(list1, list2);

	system("pause");

	return 0;
}