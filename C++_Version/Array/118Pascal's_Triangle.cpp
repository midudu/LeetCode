//Given numRows, generate the first numRows of Pascal's triangle.
//
//For example, given numRows = 5,
//Return
//
//[
//	[1],
//	[1, 1],
//	[1, 2, 1],
//	[1, 3, 3, 1],
//	[1, 4, 6, 4, 1]
//]

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
using namespace std;

class Solution {
public:
	vector<vector<int>> generate(int numRows) {
		if ( numRows == 0 )
		{
			vector<vector<int>>  temp;
			return temp;
		}
		
		else if (numRows == 1)
		{
			vector<int> temp({ 1 });
			vector<vector<int>> ret;
			ret.push_back(temp);
			return ret;
		}
		else if (numRows == 2)
		{
			vector<int> temp1({ 1 });
			vector<vector<int>> ret;
			ret.push_back(temp1);
			vector<int> temp2({ 1,1 });
			ret.push_back(temp2);
			return ret;
		}
		
		vector<int> temp({ 1 });
		vector<vector<int>> ret;
		ret.push_back(temp);
		vector<int>().swap(temp);
		vector<int> temp1({ 1,1 });
		ret.push_back(temp1);
		vector<int>().swap(temp);

		for (int i = 3; i <= numRows; ++i)
		{
			temp.push_back(1);

			int size = ret[i - 2].size();

			for (int j = 0; j < size - 1; ++j)
			{
				temp.push_back(ret[i - 2][j] + ret[i - 2][j + 1]);
			}

			temp.push_back(1);

			ret.push_back(temp);
			vector<int>().swap(temp);
		}

		return ret;
	}
};


int main()
{
	vector<int> vec1({ 7, 6, 4, 3, 1 });

	Solution sol1;
	sol1.generate(5);

	/*for (int i = 0; i < (int)number.size(); ++i)
		cout << number[i] << ' ';*/

	system("pause");

	return 0;
}