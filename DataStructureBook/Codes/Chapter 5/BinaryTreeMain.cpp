#include "stdafx.h"
#include "BinaryTree.h"

int main()
{
	BinaryTree<char> tree, tree1('M'), tree2, tree3;

	tree.createTree('@');
	tree3.createTree('@');

	cout << "高度为：" << tree.height() << endl;
	cout << "规模为：" << tree.size() << endl;
	cout << "度为2的结点个数为：" << tree.degreeEqualTwo() << endl;
	tree.preOrder();
	tree.midOrder();
	tree.postOrder();
	tree.levelTraversal();
	cout << endl;

	if (tree.isCompleteBinaryTree())
		cout << "这是一棵完全二叉树" << endl;
	else
		cout << "这不是一棵完全二叉树" << endl;

	if (tree == tree3)
		cout << "tree和tree3是两棵完全相同的树" << endl;
	else
		cout << "tree和tree3不是两棵完全相同的树" << endl;

	if (isTwoMirrorTrees(tree,tree3))
		cout << "tree和tree3互为镜像" << endl;
	else
		cout << "tree和tree3不互为镜像" << endl;

	tree2.makeTree('Y', tree, tree1);
	cout << endl;

	tree.exchange();
	cout << "左右结点交换后：" << endl;
	tree.levelTraversal();

	cout << "高度为：" << tree2.height() << endl;
	cout << "规模为：" << tree2.size() << endl;
	tree2.preOrder();
	tree2.midOrder();
	tree2.postOrder();
	cout << endl;

	system("pause");
	return 0;
}
