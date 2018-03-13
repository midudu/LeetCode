//Given a binary search tree(BST), find the lowest common ancestor(LCA) of two given nodes in the BST.
//
//According to the definition of LCA on Wikipedia : ¡°The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants(where we allow a node to be a descendant of itself).¡±
//
//    _______6______
//    /             \
// ___2__          ___8__
/// \ / \
//0      _4       7       9
/// \
//3   5
//For example, the lowest common ancestor(LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.


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
	TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
		
		if (p->val > root->val && q->val > root->val)
			return lowestCommonAncestor(root->right, p, q);
		else if (p->val < root->val && q->val < root->val)
			return lowestCommonAncestor(root->left, p, q);
		else if ((p->val < root->val && q->val > root->val)
			|| (p->val > root->val && q->val < root->val))
			return root;
		else if (p->val == root->val || q->val == root->val)
			return root;
		
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