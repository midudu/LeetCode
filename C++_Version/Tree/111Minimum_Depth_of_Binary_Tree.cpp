//Given a binary tree, find its minimum depth.
//
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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


struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	int minDepth(TreeNode* root) {
		
		if (root == NULL)
			return 0;

		else if (root->left == NULL)
			return 1 + minDepth(root->right);

		else if (root->right == NULL)
			return 1 + minDepth(root->left);

		else
			return 1 + min(minDepth(root->right), minDepth(root->left));
	}
};


int main()
{
	TreeNode* root = new TreeNode(0), *temp1 = root,*temp2 = root;

	for (int i = 1; i < 4; ++i)
	{
		temp1->left = new TreeNode(4 * i);
		temp1->right = new TreeNode(4 * i + 1);
		//temp2->left = new TreeNode(4 * i + 2);
		//temp2->right = new TreeNode(4 * i + 3);

		temp1 = temp1->left;
		//temp2 = temp2->right;
	}

	Solution sol1;

	int receive = sol1.minDepth(root);

	system("pause");

	return 0;
}