//Given a binary tree, check whether it is a mirror of itself(ie, symmetric around its center).
//
//For example, this binary tree[1, 2, 2, 3, 4, 4, 3] is symmetric :
//
//1
/// \
//2   2
/// \ / \
//3  4 4  3
//But the following[1, 2, 2, null, 3, null, 3] is not:
//1
/// \
//2   2
//\   \
//3    3
//Note:
//Bonus points if you could solve it both recursively and iteratively.

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
	bool isSymmetric(TreeNode* root) {

		if (root == NULL)
			return true;
		if (root->left == NULL && root->right == NULL)
			return true;
		else if (root->left != NULL && root->right == NULL)
			return false;
		else if (root->left == NULL && root->right != NULL)
			return false;
		

		queue<TreeNode*> node_queue;
		node_queue.push(root);
		int queue_size = 1;
		vector<char> node_value;
		TreeNode* temp_node;
		int count = 0;

		while (!node_queue.empty())
		{
			vector<char>().swap(node_value);
			count = 0;
			for (int i = 0; i < queue_size; ++i)
			{
				temp_node = node_queue.front();
				if (temp_node->left != NULL)
				{
					node_queue.push(temp_node->left);
					node_value.push_back(temp_node->left->val + '0');
					count++;
				}
				else
					node_value.push_back('n');
				if (temp_node->right != NULL)
				{
					node_queue.push(temp_node->right);
					node_value.push_back(temp_node->right->val + '0');
					count++;
				}
				else
					node_value.push_back('n');

				node_queue.pop();
			}
			
			for (int i = 0, j = (int)node_value.size() - 1; i < j; i++, j--)
			{
				if (node_value[i] != node_value[j])
					return false;
			}

			queue_size = count;
		}

		return true;
	}
};


int main()
{
	TreeNode* root = new TreeNode(1);
	TreeNode* node1 = new TreeNode(2);
	TreeNode* node2 = new TreeNode(2);
	TreeNode* node3 = new TreeNode(3);
	TreeNode* node4 = new TreeNode(4);
	TreeNode* node5 = new TreeNode(4);
	TreeNode* node6 = new TreeNode(3);
	root->left = node1;
	root->right = node2;
	node1->left = node3;
	node1->right = node4;
	node2->left = node5;
	node2->right = node6;

	Solution sol1;

	bool receive = sol1.isSymmetric(root);
	
	system("pause");

	return 0;
}