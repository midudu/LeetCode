//Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points(i, j, k) such that the distance between i and j equals the distance between i and k(the order of the tuple matters).
//
//Find the number of boomerangs.You may assume that n will be at most 500 and coordinates of points are all in the range[-10000, 10000](inclusive).
//
//Example:
//Input:
//[[0, 0], [1, 0], [2, 0]]
//
//Output :
//	2
//
//	Explanation :
//	The two boomerangs are[[1, 0], [0, 0], [2, 0]] and [[1, 0], [2, 0], [0, 0]]


#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
#include <string>
#include <stack>
#include <queue>
#include <unordered_map>
#include <unordered_set>
using namespace std;


class Solution {
public:
	int numberOfBoomerangs(vector<pair<int, int>>& points) {
		int points_size = points.size();
		int output = 0;

		for (int i = 0; i < points_size; ++i)
		{
			unordered_map<long int, int> distance_and_times;

			for (int j = 0; j < points_size; ++j)
			{
				if (i == j)
					continue;

				int x_distance = points[i].first  - points[j].first;
				int y_distance = points[i].second - points[j].second;

				int distance = x_distance * x_distance + y_distance * y_distance;

				distance_and_times[distance]++;
			}

			for (unordered_map<long int, int>::iterator iter = distance_and_times.begin(); iter != distance_and_times.end(); ++iter)
			{
				if (iter->second > 1)
					output += ( iter->second ) * ( iter->second - 1);
			}
		}

		return output;
	}
};

int main()
{
	vector<int> list1({ 1, 1, 2, 2, 3, 3 });
	vector<string> list2({ "Hello", "Alaska", "Dad", "Peace" });

	unordered_map<int, int> temp(5);


	Solution sol1;

	vector<string> receive = sol1.findWords(list2);

	system("pause");

	return 0;
}