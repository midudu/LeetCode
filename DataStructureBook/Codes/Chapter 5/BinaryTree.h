#ifndef BINARYTREE_H
#define BINARYTREE_H

#include <cstdlib>
#include <queue>
#include <list>
#include <iostream>
using namespace std;

//---------------------------------------------------------------------------//
//------------------------------模板类的定义---------------------------------//
//---------------------------------------------------------------------------//
template<class Type>
class BinaryTree
{
	                                                                              //重载运算符==。判断两棵二叉树是否完全相同
	friend bool operator==(const BinaryTree<Type>& tree1, const BinaryTree<Type>& tree2){  return checkEqual(tree1.root, tree2.root);  }

	friend bool isTwoMirrorTrees(const BinaryTree<Type>& tree1, const BinaryTree<Type>& tree2) { return checkMirror(tree1.root,tree2.root); }

private:
	class Node           //内嵌类
	{
	public:
		Node* left;      //结点左儿子
		Node* right;     //结点右儿子
		Type data;       //结点保存的数据 

		Node();                                                             //内嵌类的默认构造函数
		Node(Type item, Node* L = NULL, Node* R = NULL);                    //内嵌类的数据初始化构造函数
		~Node();                                                            //内嵌类的析构函数
	};
	Node* root;

	void clear(Node* t);
	int size(Node* t) const;
	int height(Node* t) const;

	void preOrder(Node* t) const;     //前序遍历
	void midOrder(Node* t) const;     //中序遍历
	void postOrder(Node* t) const;    //后序遍历

	int degreeEqualTwo(Node* t);      //统计度为2的结点个数

	void exchange(Node* t);           //交换二叉树所有结点的左右子树

	static bool checkEqual(Node* t1, Node* t2);    //判断两个二叉树是否完全相同

	static bool checkMirror(Node* t1, Node* t2);   //判断两个二叉树是否是镜像的

public:
	BinaryTree();                                                      //BinaryTree的默认构造函数
	BinaryTree(const Type& value);                                     //BinaryTree的数据初始化构造函数
	~BinaryTree();                                                     //BinaryTree的析构函数

	void clear();

	Type getRoot() const  { return root->data; }
	Type getLeft() const  { return root->left->data; }
	Type getRight() const { return root->right->data; }

	void makeTree(const Type& x, BinaryTree& lt, BinaryTree& rt);

	void delLeft();
	void delRight();

	bool isEmpty() const   {  return root == NULL; }
	int size() const       {  return size(root);   }
	int height() const     {  return height(root); }

	void preOrder() const;
	void midOrder() const;
	void postOrder() const;

	void createTree(Type flag);

	int degreeEqualTwo()   {  return degreeEqualTwo(root);  }   

	void levelTraversal();

	void exchange(){  if (root == NULL)    return;
	                  else                 exchange(root);  }

	bool isCompleteBinaryTree();
};






//---------------------------------------------------------------------------//
//------------------------------模板类的实现---------------------------------//
//---------------------------------------------------------------------------//

//当把模板类的定义和实现分离到两个文件的时候就会报错，必须把两者都放在头文件中
template<class Type>
BinaryTree<Type>::Node::Node()                                             
{
	left = NULL;
	right = NULL;
}

template<class Type>
BinaryTree<Type>::Node::Node(Type item, Node* L = NULL, Node* R = NULL)   
{
	data = item;
	left = L;
	right = R;
}

template<class Type>
BinaryTree<Type>::Node::~Node()                                             
{

}

template<class Type>
BinaryTree<Type>::BinaryTree()                                            
{
	root = NULL;
}

template<class Type>                                                     
BinaryTree<Type>::BinaryTree(const Type& value)
{
	root = new Node(value);
}

template<class Type>
BinaryTree<Type>::~BinaryTree()
{
	clear();
}


template<class Type>
void BinaryTree<Type>::clear()
{
	if (root != NULL)
		clear(root);
	root = NULL;
}


template<class Type>
void BinaryTree<Type>::clear(Node* t)
{
	if (t->left != NULL)
		clear(t->left);
	if (t->right != NULL)
		clear(t->right);

	delete t;
}

template<class Type>
void BinaryTree<Type>::makeTree(const Type& x, BinaryTree& lt, BinaryTree& rt)
{
	root = new Node(x, lt.root, rt.root);

	lt.root = NULL;
	rt.root = NULL;
}


template<class Type>
void BinaryTree<Type>::delLeft()
{
	BinaryTree tmp = root->left;
	root->left = NULL;
	tmp.clear();
}

template<class Type>
void BinaryTree<Type>::delRight()
{
	BinaryTree tmp = root->right;
	root->right = NULL;
	tmp.clear();
}

template<class Type>
int BinaryTree<Type>::size(Node* t) const
{
	if (t == NULL)
		return 0;

	return 1 + size(t->left) + size(t->right);
}


template<class Type>
int BinaryTree<Type>::height(Node* t) const
{
	if (t == NULL)
		return 0;
	else
	{
		int lt = height(t->left);
		int rt = height(t->right);

		return 1 + ((lt > rt) ? lt : rt);
	}
}


template<class Type>
void BinaryTree<Type>::preOrder() const
{
	if (root != NULL)
	{
		cout << "\n前序遍历：";
		preOrder(root);
	}
}


template<class Type>
void BinaryTree<Type>::midOrder() const
{
	if (root != NULL)
	{
		cout << "\n中序遍历：";
		midOrder(root);
	}
}


template<class Type>
void BinaryTree<Type>::postOrder() const
{
	if (root != NULL)
	{
		cout << "\n后序遍历：";
		postOrder(root);
	}
}


template<class Type>
void BinaryTree<Type>::preOrder(Node* t) const
{
	if (t != NULL)
	{
		cout << t->data << ' ';
		preOrder(t->left);
		preOrder(t->right);
	}
}


template<class Type>
void BinaryTree<Type>::midOrder(Node* t) const
{
	if (t != NULL)
	{
		midOrder(t->left);
		cout << t->data << ' ';
		midOrder(t->right);
	}
}


template<class Type>
void BinaryTree<Type>::postOrder(Node* t) const
{
	if (t != NULL)
	{
		postOrder(t->left);
		postOrder(t->right);
		cout << t->data << ' ';
	}
}


template<class Type>
void BinaryTree<Type>::createTree(Type flag)
{
	queue<Node*, list<Node*>> que;
	Node* tmp;
	Type x, ldata, rdata;

	cout << "\n输入根结点：";
	cin >> x;

	root = new Node(x);
	que.push(root);

	while (!que.empty())
	{
		tmp = que.front();
		que.pop();

		cout << "\n输入" << tmp->data << "的两个儿子（" << flag << "表示空结点）：";
		cin >> ldata >> rdata;

		if (ldata != flag)
			que.push(tmp->left = new Node(ldata));
		if (rdata != flag)
			que.push(tmp->right = new Node(rdata));
	}

	cout << "create completed!" << endl << endl;
}


template<class Type>
int BinaryTree<Type>::degreeEqualTwo(Node* t)
{
	if (t == NULL)
		return 0;
	else if (t->left != NULL && t->right != NULL)
		return 1 + degreeEqualTwo(t->left) + degreeEqualTwo(t->right);
	else //if (t->left == NULL || t->right == NULL)
		return degreeEqualTwo(t->left) + degreeEqualTwo(t->right);
}


template<class Type>
void BinaryTree<Type>::levelTraversal()
{
	if (root == NULL)
		return;

	else
	{
		Node* tmp = NULL;

		queue<Node*, list<Node*>> queueTree;

		queueTree.push(root);

		cout << "\r\n层次遍历：";

		while (!queueTree.empty())
		{
			tmp = queueTree.front();
			queueTree.pop();

			if (tmp->left != NULL)
				queueTree.push(tmp->left);
			if (tmp->right != NULL)
				queueTree.push(tmp->right);

			cout << tmp->data << ' ';
		}
		cout << endl;
	}
}


template<class Type>
void BinaryTree<Type>::exchange(Node* t)
{
	if (t->left != NULL)
		exchange(t->left);
	if (t->right != NULL)
		exchange(t->right);

	Node* tmp = t->left;
	t->left = t->right;
	t->right = tmp;
}


template<class Type>
bool BinaryTree<Type>::isCompleteBinaryTree()
{
	if (root == NULL)
		return true;
	else
	{
		int count = 1;       //结点个数统计
		int number = 1;      //结点编号
		Node* tmpPoint = root;
		int tmpNum = number;

		queue<Node*, list<Node*>> point;
		queue<int, list<int>> num;

		point.push(tmpPoint);
		num.push(tmpNum);

		while (!point.empty())
		{
			tmpPoint = point.front();
			tmpNum = num.front();
			point.pop();
			num.pop();

			if (tmpPoint->left != NULL)                 //根据完全二叉树的性质，如果一个结点存在左儿子，那么左儿子的编号为2n
			{
				point.push(tmpPoint->left);
				num.push(tmpNum * 2);
				++count;
			}
			if (tmpPoint->right != NULL)                 //根据完全二叉树的性质，如果一个结点存在右儿子，那么左儿子的编号为2n+1
			{
				point.push(tmpPoint->right);
				num.push(tmpNum * 2 + 1);
				++count;
			}
		}

		return (tmpNum == count);
	}
}


template<class Type>
bool BinaryTree<Type>::checkEqual(Node* t1, Node* t2)
{
	if (t1 == NULL && t2 == NULL)
		return true;
	else if (t1 == NULL && t2 != NULL)
		return false;
	else if (t1 != NULL && t2 == NULL)
		return false;
	else
	{
		if (t1->data != t2->data)
			return false;
		else
		{
			return checkEqual(t1->left, t2->left) && checkEqual(t1->right, t2->right);
		}
	}
}


template<class Type>
bool BinaryTree<Type>::checkMirror(Node* t1, Node* t2)
{
	if (t1 == NULL && t2 == NULL)
		return true;
	else if (t1 == NULL && t2 != NULL)
		return false;
	else if (t1 != NULL && t2 == NULL)
		return false;
	else
	{
		if (t1->data != t2->data)
			return false;
		else
			return checkMirror(t1->left, t2->right) && checkMirror(t1->right, t2->left);
	}
}

#endif     //BINARYTREE_H
