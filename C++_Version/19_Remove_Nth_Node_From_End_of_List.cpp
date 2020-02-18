/*
  Given a linked list, remove the n-th node from the end of list and return its head.

Example:

  Given linked list: 1->2->3->4->5, and n = 2.

  After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
  Given n will always be valid.

Follow up:
  Could you do this in one pass?
*/

#include <cassert>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};


class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        assert(n > 0);

        ListNode *fastPointer = head, *slowPointer = head;

        for (int i = 0; i < n; i++) {
            assert(fastPointer != nullptr);
            fastPointer = fastPointer->next;
        }

        if (fastPointer == nullptr) {
            return head->next;
        }

        while (fastPointer->next != nullptr) {
            fastPointer = fastPointer->next;
            slowPointer = slowPointer->next;
        }

        slowPointer->next = slowPointer->next->next;

        return head;
    }
};

int main(int argc, char *args[]) {

    auto *head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    head->next->next->next = new ListNode(4);
    head->next->next->next->next = new ListNode(5);

    Solution solution;
    ListNode *result = solution.removeNthFromEnd(head, 5);

    return 0;
}
