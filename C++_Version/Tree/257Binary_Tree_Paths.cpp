//Given a binary tree, return all root - to - leaf paths.
//
//For example, given the following binary tree :
//
//1
/// \
//2     3
//\
//5
//All root - to - leaf paths are :
//
//["1->2->5", "1->3"]

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
	vector<string> binaryTreePaths(TreeNode* root) {
		if (root == NULL)
			return vector<string>();
		
		vector<string> result;

		binaryTreePathsHelper(root, result, std::to_string(root->val) );

		return result;
	}

private:
	void binaryTreePathsHelper(TreeNode* node, vector<string>& result, string formal_string)
	{
		if (node->left == NULL && node->right == NULL)
		{
			result.push_back(formal_string);
			return;
		}

		if (node->left != NULL)
			binaryTreePathsHelper(node->left, result, formal_string + "->" + std::to_string(node->left->val));
		if (node->right != NULL)
			binaryTreePathsHelper(node->right, result, formal_string + "->" + std::to_string(node->right->val));
	}
};


int main()
{
	TreeNode* root = new TreeNode(1);
	TreeNode* node1 = new TreeNode(2);
	TreeNode* node2 = new TreeNode(3);
	TreeNode* node3 = new TreeNode(5);
	TreeNode* node4 = new TreeNode(7);
	root->left = node1;
	root->right = node2;
	node1->right = node3;

	Solution sol1;

	vector<string> receive = sol1.binaryTreePaths(root);
	
	system("pause");

	return 0;
}