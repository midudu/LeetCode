//Given a singly linked list, determine if it is a palindrome.

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
	bool isPalindrome(ListNode* head) 
	{
		if (head == NULL || head->next == NULL)
			return true;

		ListNode* pfast = head, *pslow = head;          //至少有两个数

		while (pfast->next != NULL && pfast->next->next != NULL)   //寻找中点
		{
			pslow = pslow->next;

			pfast = pfast->next->next;
		}

		pfast = head;
		ListNode *ppre = NULL, *pcur = pslow->next, *pnext;
		
		while (pcur!=NULL)                           //把中点以后的部分反向重新排序
		{
			pnext = pcur->next;
			pcur->next = ppre;
			ppre = pcur;
			pcur = pnext;
		}

		while (ppre != NULL)
		{
			if (pfast->val != ppre->val)
				return false;

			pfast = pfast->next;
			ppre = ppre->next;
		}

		return true;
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