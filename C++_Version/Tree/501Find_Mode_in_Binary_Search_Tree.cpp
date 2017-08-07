////Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
//
//Assume a BST is defined as follows :
//
//The left subtree of a node contains only nodes with keys less than or equal to the node's key.
//The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
//Both the left and right subtrees must also be binary search trees.
//For example :
//Given BST[1, null, 2, 2],
//1
//\
//2
///
//2
//return[2].
//
//Note: If a tree has more than one mode, you can return them in any order.


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
	Solution(){
		unordered_map<int, int> storage_;
	}

	vector<int> findMode(TreeNode* root) 
	{
		findMode_helper(root);

		vector<int> output;
		int count = 0;

		for (unordered_map<int, int>::iterator iter = storage_.begin(); iter != storage_.end(); iter++)
		{
			if (iter->second > count)
			{
				vector<int>().swap(output);
				count = iter->second;
				output.push_back(iter->first);
			}
			else if (iter->second == count)
			{
				output.push_back(iter->first);
			}
		}

		return output;
	}

private:
	unordered_map<int, int> storage_;

	void findMode_helper(TreeNode* root)
	{
		if (root == NULL)
			return;

		if (!storage_.count(root->val))
			storage_[root->val] = 1;
		else
			storage_[root->val] += 1;

		findMode_helper(root->left);
		findMode_helper(root->right);
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