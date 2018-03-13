//Write a program to find the node at which the intersection of two singly linked lists begins.
//
//
//For example, the following two linked lists :
//
//A:          a1 ¡ú a2
//	                 ¨K
//	                  c1 ¡ú c2 ¡ú c3
//	                 ¨J
//	B : b1 ¡ú b2 ¡ú b3
//	begin to intersect at node c1.
//
//
//	Notes :
//
//	If the two linked lists have no intersection at all, return null.
//	The linked lists must retain their original structure after the function returns.
//	You may assume there are no cycles anywhere in the entire linked structure.
//	Your code should preferably run in O(n) time and use only O(1) memory.

#include <vector>
#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <functional>
using namespace std;


//* Definition for singly-linked list.
struct ListNode 
{
	int val;
	ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
		ListNode *ptemp1 = headA, *ptemp2 = headB;

		while (true)
		{
			if (ptemp1 == ptemp2)
			{
				return ptemp1;
			}

			ptemp1 = ptemp1 ? ptemp1->next : headB;
			ptemp2 = ptemp2 ? ptemp2->next : headA;
		}
	}
};

int main()
{
	ListNode* headA = new ListNode(0), *ptemp1, *ptemp2 = headA ;

	int a[10] = { 0,1,2,2,2,4,4,6,7,8 };

	for (int i = 1; i < 10; ++i)
	{
		ptemp1 = new ListNode(a[i]);
		ptemp2->next = ptemp1;
		ptemp2 = ptemp1;
	}

	ListNode* headB = new ListNode(0);
	ptemp2 = headB;

	int b[12] = { 0,1,2,2,2,4,4,6,7,8, 9,10 };

	for (int i = 1; i < 12; ++i)
	{
		ptemp1 = new ListNode(a[i]);
		ptemp2->next = ptemp1;
		ptemp2 = ptemp1;
	}

	headB->next->next->next = headA->next->next->next->next;

	Solution sol1;
	ListNode* receive = sol1.getIntersectionNode(headA, headB);

	system("pause");

	return 0;
}