//Given a linked list, determine if it has a cycle in it.
//
//Follow up :
//Can you solve it without using extra space ?

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
	bool hasCycle(ListNode *head) {
		ListNode *ptemp1 = head, *ptemp2 = head;

		while (ptemp2!=NULL && ptemp2->next!=NULL)
		{
			ptemp1 = ptemp1->next;
			ptemp2 = ptemp2->next->next;

			if (ptemp1 == ptemp2)
				return true;
		}
		return false;
	}
};

int main()
{
	ListNode* head = new ListNode(0), *ptemp1, *ptemp2 = head ;



	for (int i = 1; i < 10; ++i)
	{
		ptemp1 = new ListNode(i);
		ptemp2->next = ptemp1;
		ptemp2 = ptemp1;
	}

	ptemp2->next = head->next;

	/*ptemp2 = head;
	while (true)
	{
		cout << ptemp2->val << endl;
		ptemp2 = ptemp2->next;
		if (ptemp2 == NULL)
			break;
	}*/

	Solution sol1;

	if (sol1.hasCycle(head))
		cout << "true";
	else
		cout << "false";

	system("pause");

	return 0;
}