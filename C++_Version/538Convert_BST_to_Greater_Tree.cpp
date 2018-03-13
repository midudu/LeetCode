//Given a Binary Search Tree(BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
//
//Example:
//
//Input: The root of a Binary Search Tree like this :
//	5
//	/ \
//	2     13
//
//	Output: The root of a Greater Tree like this :
//	18
//	/ \
//	20     13


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
	TreeNode* convertBST(TreeNode* root) {
		convertBST_Helper(root);

		return root;
	}

private:
	int sum = 0;

	void convertBST_Helper(TreeNode* root)
	{
		if (root == NULL)
			return;


		convertBST_Helper(root->right);

		sum += root->val;
		root->val = sum;

		convertBST_Helper(root->left);
	}
};


int main()
{
	TreeNode* root = new TreeNode(3), *temp1 = root;

	temp1->left = new TreeNode(1);
	temp1->right = new TreeNode(6);
	//temp1 = temp1->left;
	//temp1->right = new TreeNode(1);
	//temp1 = temp1->right;
	//temp1->left = new TreeNode(5);
	//temp1->right = new TreeNode(6);


	Solution sol1;

	temp1 = sol1.convertBST(root);

	//cout << receive << endl;

	system("pause");

	return 0;
}