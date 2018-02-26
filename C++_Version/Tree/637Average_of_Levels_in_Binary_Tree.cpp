//Given a non - empty binary tree, return the average value of the nodes on each level in the form of an array.
//
//Example 1:
//Input:
//3
/// \
//9  20
/// \
//15   7
//Output: [3, 14.5, 11]
//	Explanation :
//	The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11. Hence return[3, 14.5, 11].
//	Note :
//	The range of node's value is in the range of 32-bit signed integer.

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
	vector<double> averageOfLevels(TreeNode* root) {
		if (root == NULL)
			return vector<double>();

		vector<double> result;
		queue<TreeNode*> queue1, queue2;
		int count = 0;
		long sum = 0;
		TreeNode* temp_node;

		queue1.push(root);

		while (true)
		{
			count = sum = 0;
			while (!queue1.empty())
			{
				temp_node = queue1.front();

				sum += temp_node->val;
				count++;

				if (temp_node->left != NULL)
					queue2.push(temp_node->left);
				if (temp_node->right != NULL)
					queue2.push(temp_node->right);

				queue1.pop();
			}
			if (count!=0)
				result.push_back(double(sum) / count);

			count = sum = 0;
			while (!queue2.empty())
			{
				temp_node = queue2.front();

				sum += temp_node->val;
				count++;

				if (temp_node->left != NULL)
					queue1.push(temp_node->left);
				if (temp_node->right != NULL)
					queue1.push(temp_node->right);

				queue2.pop();
			}
			if (count!=0)
				result.push_back(double(sum) / count);

			if (queue1.empty() && queue2.empty())
				break;
		}

		return result;
	}
};


int main()
{
	TreeNode* root = new TreeNode(3);
	TreeNode* node1 = new TreeNode(9);
	TreeNode* node2 = new TreeNode(20);
	TreeNode* node3 = new TreeNode(15);
	TreeNode* node4 = new TreeNode(7);
	root->left = node1;
	root->right = node2;
	node2->left = node3;
	node2->right = node4;

	Solution sol1;

	vector<double> receive = sol1.averageOfLevels(root);
	
	system("pause");

	return 0;
}