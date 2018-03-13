//Find the sum of all left leaves in a given binary tree.
//
//Example:
//
//3
/// \
//9  20
/// \
//15   7
//
//There are two left leaves in the binary tree, with values 9 and 15 respectively.Return 24.


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
	int sumOfLeftLeaves(TreeNode* root) {
		if (root == NULL)
			return 0;

		output = 0;

		sumOfLeftLeaves_Left_Helper(root->left);
		sumOfLeftLeaves_Right_Helper(root->right);

		return output;
	}

private:
	int output;

	void sumOfLeftLeaves_Left_Helper(TreeNode* root)
	{
		if (root == NULL)
			return;

		if (root->left == NULL && root->right == NULL)     //definitely a left leaf node
			output += root->val;
		else
		{
			sumOfLeftLeaves_Left_Helper(root->left);
			sumOfLeftLeaves_Right_Helper(root->right);
		}
	}

	void sumOfLeftLeaves_Right_Helper(TreeNode* root)
	{
		if (root == NULL)
			return;

		sumOfLeftLeaves_Left_Helper(root->left);
		sumOfLeftLeaves_Right_Helper(root->right);
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