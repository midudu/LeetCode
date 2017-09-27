//You are given a map in form of a two - dimensional integer grid where 1 represents land and 0 represents water.Grid cells are connected horizontally / vertically(not diagonally).The grid is completely surrounded by water, and there is exactly one island(i.e., one or more connected land cells).The island doesn't have "lakes" (water inside that isn't connected to the water around the island).One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

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
	int islandPerimeter(vector<vector<int>>& grid) {
		int height = (int)grid.size();
		int width = (int)grid[0].size();

		int perimeter = 0;
		int temp;

		for (int i = 0; i < height; ++i)
		{
			for (int j = 0; j < width; ++j)
			{
				if (grid[i][j] == 1)
				{
					temp = position_detect(i, j, grid);
					perimeter += temp;
				}
				
			}
		}

		return perimeter;
	}

private:
	int position_detect(int i, int j, vector<vector<int>>& grid)
	{
		int temp = 0;

		if (i + 1 < (int)grid.size())
		{
			if (grid[i + 1][j] == 1)
				temp++;
		}
		if (i - 1 >= 0)
		{
			if (grid[i - 1][j] == 1)
				temp++;
		}
		if (j + 1 < (int)grid[0].size())
		{
			if (grid[i][j + 1] == 1)
				temp++;
		}
		if (j - 1 >= 0)
		{
			if (grid[i][j - 1] == 1)
				temp++;
		}

		return (4 - temp);
	}
};


int main()
{
	Solution sol1;
	string pattern = "abba", str = "dog cat cat dog";
	vector<int> a({ 1,3,2,2,5,2,3,7 });
	vector<vector<int>> grid({
		{0,1,0,0},
	{1,1,1,0},
	{0,1,0,0},
	{1,1,0,0} });

	int receive_flag = sol1.islandPerimeter(grid);

	system("pause");

	return 0;
}