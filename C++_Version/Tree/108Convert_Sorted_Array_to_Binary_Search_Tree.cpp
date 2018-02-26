//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//For this problem, a height - balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//
//Example:
//
//Given the sorted array : [-10, -3, 0, 5, 9],
//
//One possible answer is : [0, -3, 9, -10, null, 5], which represents the following height balanced BST :
//
//0
/// \
//- 3   9
/// /
//-10  5


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
#include <queue>
using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
	TreeNode* sortedArrayToBST(vector<int>& nums) 
	{
		if (nums.empty())
			return NULL;

		int start_index = 0, end_index = (int)nums.size() - 1;
		int middle_index = (start_index + end_index) / 2;
		TreeNode* root = new TreeNode(nums[middle_index]);

		sortedArrayToBSTHelper(nums, start_index, end_index, middle_index, root);

		return root;
	}

private:
	void sortedArrayToBSTHelper(vector<int>& nums, int start_index,
		int end_index, int middle_index, TreeNode*& root_node)
	{
		if (middle_index - 1 >= start_index)
		{
			int new_end_index = middle_index - 1;
			int new_middle_index_1 = (start_index + new_end_index) / 2;
			TreeNode* left_node = new TreeNode(nums[new_middle_index_1]);
			root_node->left = left_node;

			sortedArrayToBSTHelper(nums, start_index, new_end_index, new_middle_index_1,
				left_node);
		}
		
		if (middle_index + 1 <= end_index)
		{
			int new_start_index = middle_index + 1;
			int new_middle_index_2 = (new_start_index + end_index) / 2;
			TreeNode* right_node = new TreeNode(nums[new_middle_index_2]);
			root_node->right = right_node;

			sortedArrayToBSTHelper(nums, new_start_index, end_index, new_middle_index_2,
				right_node);
		}
	}
};


int main()
{
	vector<int> array({ -10, -3, 0, 5, 9 });

	Solution sol1;

	TreeNode* receive = sol1.sortedArrayToBST(array);
	
	system("pause");

	return 0;
}