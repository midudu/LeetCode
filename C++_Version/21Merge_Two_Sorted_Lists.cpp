//Merge two sorted linked lists and return it as a new list.The new list should be made by splicing together the nodes of the first two lists.

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
	ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) 
	{
		ListNode origin(0);
		ListNode* head = &origin;

		while (l1 && l2)
		{
			if (l1->val < l2->val)
			{
				head->next = l1;
				l1 = l1->next;
			}
			else
			{
				head->next = l2;
				l2 = l2->next;
			}
			head = head->next;
		}

		head->next = l1 ? l1 : l2;

		return origin.next;
	}
};

int main()
{
	ListNode* headA = new ListNode(0), *ptemp1, *ptemp2 = headA ;

	int a[] = { 0,1,2,6,8,9,10 };

	for (int i = 1; i < 8; ++i)
	{
		ptemp1 = new ListNode(a[i]);
		ptemp2->next = ptemp1;
		ptemp2 = ptemp1;
	}


	Solution sol1;
	headA = sol1.reverseList(headA);

	system("pause");

	return 0;
}