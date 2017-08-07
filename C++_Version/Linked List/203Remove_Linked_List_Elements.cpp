//Remove all elements from a linked list of integers that have value val.
//
//Example
//Given : 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
//	Return: 1 --> 2 --> 3 --> 4 --> 5

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
	ListNode* removeElements(ListNode* head, int val) {
		ListNode *ptemp = head,*pdelete;

		while (true)                             //保证处理后头结点的值不是val
		{
			if (ptemp == NULL)
				return NULL;

			if (ptemp->val == val)
			{
				pdelete = ptemp;
				ptemp = ptemp->next;
				delete pdelete;
			}
			else
			{
				head = ptemp;
				break;
			}
		}

		while (true)
		{
			if (ptemp->next == NULL)
				return head;
			else
			{
				if (ptemp->next->val == val)
				{
					pdelete = ptemp->next;
					ptemp->next = ptemp->next->next;
					delete pdelete;
				}
				else
					ptemp = ptemp->next;
			}	
		}
	}
};

int main()
{
	ListNode* headA = new ListNode(0), *ptemp1, *ptemp2 = headA ;

	int a[8] = { 0,1,2,6,3,4,5,6 };

	for (int i = 1; i < 8; ++i)
	{
		ptemp1 = new ListNode(a[i]);
		ptemp2->next = ptemp1;
		ptemp2 = ptemp1;
	}


	Solution sol1;
	ListNode* receive = sol1.removeElements(headA, 6);

	system("pause");

	return 0;
}