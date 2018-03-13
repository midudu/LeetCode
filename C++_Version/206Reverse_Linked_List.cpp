//Reverse a singly linked list.

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
	ListNode* reverseList(ListNode* head) {
		ListNode *pre = NULL, *now = head, *next;

		while (now != NULL)
		{
			next = now->next;
			now->next = pre;
			pre = now;
			now = next;
		}

		return pre;
	}
};

int main()
{
	ListNode* headA = new ListNode(0), *ptemp1, *ptemp2 = headA ;

	int a[] = { 0,1,2,6,3,4,5,6 };

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