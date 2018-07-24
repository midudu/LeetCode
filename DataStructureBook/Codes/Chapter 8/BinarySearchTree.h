#ifndef BINARYSEARCHTREE_H
#define BINARYSEARCHTREE_H


template <class Type>
class BinarySearchTree
{
private:
	struct BinaryNode
	{
		Type data;
		BinaryNode* left;
		BinaryNode* right;

		BinaryNode(const Type& thedata, BinaryNode* lt, BinaryNode* rt) :data(thedata), left(lt), right(rt) { }
	};

	BinaryNode* root;

	void insert(const Type& x, BinaryNode*& t);
	void remove(const Type& x, BinaryNode*& t);
	bool find(const Type& x, BinaryNode* t) const;
	void makeEmpty(BinaryNode* t);



public:
	BinarySearchTree(BinaryNode* t = NULL)  { root = t; }
	~BinarySearchTree()                     { makeEmpty(root); }

	bool find(const Type& x) const;
	void insert(const Type& x);
	void remove(const Type& x);

	Type getRootData();
};


template<class Type>
bool BinarySearchTree<Type>::find(const Type& x) const
{
	return find(x, root);
}


template<class Type>
bool BinarySearchTree<Type>::find(const Type& x, BinaryNode* t) const
{
	if (t == NULL)
		return false;
	else
	{
		if (x < t->data)
			return find(x, t->left);
		else if (x > t->data)
			return find(x, t->right);
		else
			return true;
	}
}


template<class Type>
void BinarySearchTree<Type>::insert(const Type& x)
{
	//if (root == NULL)
	//{
		//root = new BinaryNode(x,NULL,NULL);
	//}
	//else
		insert(x, root);
}


template<class Type>
void BinarySearchTree<Type>::insert(const Type& x, BinaryNode*& t)
{
	if (t == NULL)
	{
		t = new BinaryNode(x, NULL, NULL);
	}
	else if (x < t->data)
		insert(x, t->left);
	else if (x > t->data)
		insert(x, t->right);
}


template<class Type>
void BinarySearchTree<Type>::remove(const Type& x)
{
	remove(x, root);
}


template<class Type>
void BinarySearchTree<Type>::remove(const Type& x, BinaryNode*& t)
{
	if (t == NULL)
		return;

	if (x < t->data)
		remove(x, t->left);
	else if (x > t->data)
		remove(x, t->right);
	else
	{
		if (t->left != NULL && t->right != NULL)             //有两个儿子
		{
			BinaryNode* tmp = t->right;

			while (tmp->left != NULL)
				tmp = tmp->left;

			t->data = tmp->data;

			remove(t->data, t->right);
		}
		else                                                 //有一个儿子或没有儿子
		{
			BinaryNode* oldNode = t;

			t = (t->left != NULL) ? t->left : t->right;

			delete oldNode;
		}
	}
}



template<class Type>
void BinarySearchTree<Type>::makeEmpty(BinaryNode* t)
{
	if (root != NULL)
	{
		if (t->left != NULL)
			makeEmpty(t->left);
		if (t->right != NULL)
			makeEmpty(t->right);

		delete t;
	}

	root = NULL;
}



template<class Type>
Type BinarySearchTree<Type>::getRootData()
{
	if (root == NULL)
	{
		cout << "根结点为NULL" << endl;
		return -1;
	}
	else
		return root->data;
}


#endif //BINARYSEARCHTREE_H
