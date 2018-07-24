#include <iostream>
#include <cstdlib>
using namespace std;

template<class TypeOfEdge>
class graph
{
public:
	virtual bool insert(int u, int v, TypeOfEdge w) = 0;
	virtual bool remove(int u, int v) = 0;
	virtual bool exist(int u, int v) const = 0;

protected:
	int Vers;
	int Edges;
};


template<class TypeOfVer, class TypeOfEdge>
class adjListGraph :public graph<TypeOfEdge>
{
public:
	adjListGraph(int vSize, const TypeOfVer d[]);
	bool insert(int u, int v, TypeOfEdge w);
	bool remove(int u, int v);
	bool exist(int u, int v) const;
	~adjListGraph();

private:
	struct edgeNode
	{
		int end;
		TypeOfEdge weight;
		edgeNode* next;

		edgeNode(int e, TypeOfEdge w, edgeNode* n = NULL)
		{
			end = e;
			weight = w;
			next = n;
		}
	};

	struct verNode
	{
		TypeOfVer ver;
		edgeNode* head;
		verNode(edgeNode* h = NULL)
		{
			head = h;
		}
	};

	verNode* verList;
};



int main()
{
	adjListGraph<char, int> g(10, "abcdefghij");
	g.insert(0, 5, 9);
	g.insert(0, 3, 10);

	return 0;
}

template<class TypeOfVer, class TypeOfEdge>
adjListGraph<TypeOfVer, TypeOfEdge>::adjListGraph(int vSize, const TypeOfVer d[])
{
	Vers = vSize;
	Edges = 0;

	verList = new verNode[vSize];

	for (int i = 0; i < Vers; ++i)
		verList[i].ver = d[i];
}

template<class TypeOfVer, class TypeOfEdge>
bool adjListGraph<TypeOfVer, TypeOfEdge>::insert(int u, int v, TypeOfEdge w)
{
	verList[u].head = new edgeNode(v, w, verList[u].head);
	++Edges;
	return true;
}

template<class TypeOfVer, class TypeOfEdge>
bool adjListGraph<TypeOfVer, TypeOfEdge>::remove(int u, int v)
{
	edgeNode* p = verList[u].head, *q;
	
	if (p == NULL)
		return false;

	if (p->end == v)
	{
		verList[u].head = p->next;
		delete p;
		--Edges;
		return true;
	}

	while (p->next != NULL && p->next->end != v)
		p = p->next;
	if (p->next == NULL)
		return false;
	q = p->next;
	p->next = q->next;
	delete q;
	--Edges;
	return true;
}

template<class TypeOfVer, class TypeOfEdge>
bool adjListGraph<TypeOfVer, TypeOfEdge>::exist(int u, int v) const
{
	edgeNode* p = verList[u].head;

	while (p != NULL && p->end != v)
		p = p->next;

	if (p == NULL)
		return false;
	else
		return true;
}

template<class TypeOfVer, class TypeOfEdge>
adjListGraph<TypeOfVer, TypeOfEdge>::~adjListGraph()
{
	edgeNode* p;

	for (int i = 0; i < Vers; ++i)
	{
		while ((p = verList[i].head) != NULL)
		{
			verList[i].head = p->next;
			delete p;
		}
	}

	delete[] verList;
}
