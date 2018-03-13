//Given a non - empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
//
//Example 1:
//[[0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
//[0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
//[0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
//[0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
//[0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
//[0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
//[0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]]
//Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4 - directionally.
//Example 2:
//[[0, 0, 0, 0, 0, 0, 0, 0]]
//Given the above grid, return 0.

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
	int maxAreaOfIsland(vector<vector<int>>& grid) {
		int Rows = (int)grid.size();
		int Cols = (int)grid[0].size();

		int current_point_island = 0;
		int max_island = 0;

		for (int row = 0; row < Rows; row++)
		{
			for (int col = 0; col < Cols; col++)
			{
				if (grid[row][col] == 1)
				{
					current_point_island = maxAreaOfIslandHelper(grid, row, col);

					max_island = max(current_point_island, max_island);
				}
			}
		}

		return max_island;
	}

private:
	int maxAreaOfIslandHelper(vector<vector<int>>& grid, int row, int col)
	{
		if (row < 0 || row >= (int)grid.size() || col < 0 || col >= (int)grid[0].size() || grid[row][col] !=1 )
			return 0;

		grid[row][col] = 2;

		return 1 + maxAreaOfIslandHelper(grid, row - 1, col) + maxAreaOfIslandHelper(grid, row + 1, col)
			+ maxAreaOfIslandHelper(grid, row, col - 1) + maxAreaOfIslandHelper(grid, row, col + 1);
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