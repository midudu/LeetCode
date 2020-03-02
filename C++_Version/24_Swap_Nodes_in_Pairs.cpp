/*
  Given a linked list, swap every two adjacent nodes and return its head.

  You may not modify the values in the list's nodes, only nodes itself may be
changed.

Example:

  Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};


class Solution {
public:
    ListNode *swapPairs(ListNode *head) {

        ListNode pseudoHead = ListNode(0);
        ListNode *pointer = &pseudoHead;

        ListNode *nextNextNode, *nextNode;

        while (head && head->next) {
            nextNode = head->next;
            nextNextNode = nextNode->next;

            pointer->next = nextNode;
            nextNode->next = head;
            pointer = pointer->next->next;

            head = nextNextNode;
        }

        pointer->next = head;

        return pseudoHead.next;
    }
};

int main() {

    ListNode *head = new ListNode(1);
    head->next = new ListNode(2);
    head->next->next = new ListNode(3);
    //head->next->next->next = new ListNode(4);

    ListNode* result = Solution().swapPairs(head);

    return 0;
}
