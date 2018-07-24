#ifndef AVLTREE_H
#define AVLTREE_H

template<class Type>
class AvlTree
{
private:
	struct AvlNode
	{
		Type data;
		AvlNode* left;
		AvlNode* right;
		int height;              //结点高度

		AvlNode(const Type& element, AvlNode* lt, AvlNode*rt, int h = 0) :data(element), left(lt), right(rt), height(h)   {  }
	};

	void insert(const Type& x, AvlNode*& t);
	bool remove(const Type& x, AvlNode*& t);
	void makeEmpty(AvlNode*& t);
};


#endif                //AVLTREE_H
