//You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
//
//The null node needs to be represented by empty parenthesis pair "()".And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
//
//Example 1:
//Input: Binary tree : [1, 2, 3, 4]
//	1
//	/ \
//	2     3
//	/
//	4
//
//	Output: "1(2(4))(3)"
//
//	Explanation : Originallay it needs to be "1(2(4)())(3()())",
//	but you need to omit all the unnecessary empty parenthesis pairs.
//	And it will be "1(2(4))(3)".
//	Example 2 :
//	Input : Binary tree : [1, 2, 3, null, 4]
//	1
//	/ \
//	2     3
//	\
//	4
//
//	Output: "1(2()(4))(3)"
//
//	Explanation : Almost the same as the first example,
//	except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.


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
	string tree2str(TreeNode* t) {
		string output;

		tree2str_helper(t, output);

		return output;
	}

private:
	void tree2str_helper(TreeNode* t, string& output) 
	{
		if (t != NULL)
			output.append(to_string(t->val));
		else
			return;


		if (t->left != NULL)
		{
			output.append("(");

			tree2str_helper(t->left, output);

			output.append(")");
		}
		if (t->right != NULL)
		{
			if (t->left == NULL)
				output.append("()");

			output.append("(");

			tree2str_helper(t->right, output);

			output.append(")");
		}
	}
};


int main()
{
	TreeNode* root = new TreeNode(1), *temp1 = root;

	temp1->left = new TreeNode(2);
	temp1->right = new TreeNode(3);
	temp1 = temp1->left;
	temp1->right = new TreeNode(4);


	Solution sol1;

	string receive = sol1.tree2str(root);

	cout << receive << endl;

	system("pause");

	return 0;
}