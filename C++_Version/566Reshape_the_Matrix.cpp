//In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

//You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

//The reshaped matrix need to be filled with all the elements of the original matrix in the same row - traversing order as they were.

//If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

//Example 1:
//Input:
//nums =
//[[1, 2],
//[3, 4]]
//r = 1, c = 4
//Output :
//	[[1, 2, 3, 4]]
//Explanation :
//	The row - traversing of nums is[1, 2, 3, 4].The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
//	Example 2 :
//	Input :
//	nums =
//	[[1, 2],
//	[3, 4]]
//			r = 2, c = 4
//				Output :
//				[[1, 2],
//				[3, 4]]
//			Explanation :
//				There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix.So output the original matrix.
//				Note :
//				The height and width of the given matrix is in range[1, 100].
//				The given r and c are all positive.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
using namespace std;

class Solution {
public:
	vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) 
	{
		int rows = nums.size();
		int cols = nums[0].size();

		if (rows * cols != r * c)
			return nums;

		vector<int> temp1;
		vector<vector<int>> ret;
		int count = 0;

		for (int i = 0; i < rows; ++i)
		{
			for (int j = 0; j < cols; ++j)
			{
				temp1.push_back(nums[i][j]);
				count++;

				if (count == c)
				{
					ret.push_back(temp1);
					vector<int>().swap(temp1);
					count = 0;
				}
			}
		}

		return ret;
	}
};


int main()
{
	vector<int> vec1({ 1, 2});
	vector<int> vec2({ 3, 4});
	vector<vector<int>> mat1;
	mat1.push_back(vec1);
	mat1.push_back(vec2);

	Solution sol1;
	vector<vector<int>> ret1 = sol1.matrixReshape(mat1, 1, 4);

	/*for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';*/

	system("pause");

	return 0;
}