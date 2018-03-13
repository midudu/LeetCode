//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.

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
	ListNode* deleteDuplicates(ListNode* head) {
		ListNode *ptemp1 = head, *ptemp2;

		while (ptemp1 != NULL)
		{
			ptemp2 = ptemp1->next;

			if (ptemp2 != NULL)
			{
				if (ptemp1->val == ptemp2->val)
				{
					ptemp1->next = ptemp2->next;
					continue;
				}
			}

			ptemp1 = ptemp1->next;
		}

		return head;
	}
};

int main()
{
	ListNode* head = new ListNode(0), *ptemp1, *ptemp2 = head ;

	int a[10] = { 0,1,2,2,2,4,4,6,7,8 };

	for (int i = 1; i < 10; ++i)
	{
		ptemp1 = new ListNode(a[i]);
		ptemp2->next = ptemp1;
		ptemp2 = ptemp1;
	}

	//ptemp2->next = head->next;

	/*ptemp2 = head;
	while (true)
	{
		cout << ptemp2->val << endl;
		ptemp2 = ptemp2->next;
		if (ptemp2 == NULL)
			break;
	}*/

	Solution sol1;
	ListNode* receive = sol1.deleteDuplicates(head);

	system("pause");

	return 0;
}