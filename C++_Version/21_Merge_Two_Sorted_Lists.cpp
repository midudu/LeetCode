/*
  Merge two sorted linked lists and return it as a new list. The new list
should be made by splicing together the nodes of the first two lists.

Example:

  Input: 1->2->4, 1->3->4
  Output: 1->1->2->3->4->4
*/

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};


class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {
        ListNode pseudoHead(0);
        ListNode *pointer = &pseudoHead;

        while (l1 && l2) {
            if (l1->val < l2->val) {
                pointer->next = l1;
                l1 = l1->next;
            } else {
                pointer->next = l2;
                l2 = l2->next;
            }
            pointer = pointer->next;
        }

        pointer->next = l1 ? l1 : l2;

        return pseudoHead.next;
    }
};

int main(int argc, char** args) {

    ListNode* l1 = new ListNode(1);
    l1->next = new ListNode(2);
    l1->next->next = new ListNode(4);

    ListNode* l2 = new ListNode(1);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(4);

    Solution solution;
    ListNode* result = solution.mergeTwoLists(l1, l2);

    return 0;
}
