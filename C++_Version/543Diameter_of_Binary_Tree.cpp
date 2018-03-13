//Given a binary tree, you need to compute the length of the diameter of the tree.The diameter of a binary tree is the length of the longest path between any two nodes in a tree.This path may or may not pass through the root.
//
//Example:
//Given a binary tree
//1
/// \
//2   3
/// \
//4   5
//Return 3, which is the length of the path[4, 2, 1, 3] or [5, 2, 1, 3].
//
//Note: The length of path between two nodes is represented by the number of edges between them.


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
	int diameterOfBinaryTree(TreeNode* root) {
		if (root == NULL)
			return 0;

		int sum1 = diameterOfBinaryTree_helper(root->left) + diameterOfBinaryTree_helper(root->right);

		int sum2 = max(diameterOfBinaryTree(root->left), diameterOfBinaryTree(root->right));

		return max(sum1, sum2);
	}


private:
	int diameterOfBinaryTree_helper(TreeNode* root) {
		if (root == NULL)
			return 0;

		return 1 + max(diameterOfBinaryTree_helper(root->left), diameterOfBinaryTree_helper(root->right));
	}
};


int main()
{
	TreeNode* root = new TreeNode(3), *temp1 = root;

	temp1->left = new TreeNode(1);
	//temp1->right = new TreeNode(3);
	temp1 = temp1->left;
	temp1->right = new TreeNode(1);
	//temp1 = temp1->right;
	//temp1->left = new TreeNode(5);
	//temp1->right = new TreeNode(6);


	Solution sol1;

	vector<int> receive = sol1.findMode(root);

	//cout << receive << endl;

	system("pause");

	return 0;
}