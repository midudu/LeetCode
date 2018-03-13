//Invert a binary tree.
//
//4
/// \
//2     7
/// \ / \
//1   3 6   9
//to
//4
/// \
//7     2
/// \ / \
//9   6 3   1

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

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	TreeNode* invertTree(TreeNode* root) 
	{
		invertTreeHelper(root);

		return root;
	}

private:
	void invertTreeHelper(TreeNode* node)
	{
		if (node == NULL)
			return;

		if (node->left != NULL)
			invertTreeHelper(node->left);
		if (node->right != NULL)
			invertTreeHelper(node->right);

		TreeNode* temp_node = node->left;
		node->left = node->right;
		node->right = temp_node;
	}
};


int main()
{
	TreeNode* root = new TreeNode(4);

	root->left = new TreeNode(2);
	root->right = new TreeNode(7);

	root->left->left = new TreeNode(1);
	root->left->right = new TreeNode(3);

	root->right->left = new TreeNode(6);
	root->right->right = new TreeNode(9);

	Solution sol1;

	root = sol1.invertTree(root);
	
	system("pause");

	return 0;
}