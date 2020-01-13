/*
  You are given two non-empty linked lists representing two non-negative
integers. The digits are stored in reverse order and each of their nodes
contain a single digit. Add the two numbers and return it as a linked list.

  You may assume the two numbers do not contain any leading zero, except the
number 0 itself.

Example:

  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  Output: 7 -> 0 -> 8
  Explanation: 342 + 465 = 807.
*/


struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {

        auto *pseudoHead = new ListNode(0);
        ListNode *pointer = pseudoHead;

        bool carryBit = false;
        while (l1 != nullptr || l2 != nullptr) {

            int currentResult = 0;

            if (l1) {
                currentResult += l1->val;
                l1 = l1->next;
            }
            if (l2) {
                currentResult += l2->val;
                l2 = l2->next;
            }
            if (carryBit) {
                currentResult += 1;
            }

            if (currentResult > 9) {
                currentResult -= 10;
                carryBit = true;
            } else {
                carryBit = false;
            }

            pointer->next = new ListNode(currentResult);
            pointer = pointer->next;
        }

        if (carryBit) {
            pointer->next = new ListNode(1);
        }

        ListNode *result = pseudoHead->next;
        delete pseudoHead;

        return result;
    }
};

int main(int argc, char **argv) {

    Solution solution = Solution();

    ListNode *head1 = new ListNode(2);
    head1->next = new ListNode(4);
    head1->next->next = new ListNode(3);

    ListNode *head2 = new ListNode(5);
    head2->next = new ListNode(6);
    head2->next->next = new ListNode(4);

    ListNode *result = solution.addTwoNumbers(head1, head2);

    return 0;
}
