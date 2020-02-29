/*
  Merge k sorted linked lists and return it as one sorted list. Analyze and
describe its complexity.

Example:

Input:
[
1->4->5,
1->3->4,
2->6
]

Output: 1->1->2->3->4->4->5->6
*/

#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(nullptr) {}
};


class Solution {
public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        if (lists.empty()) {
            return nullptr;
        }

        return mergeKLists(lists, 0, (int) lists.size() - 1);
    }

private:
    ListNode *mergeKLists(const vector<ListNode *> &lists, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return lists[startIndex];
        }

        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        ListNode *l1 = mergeKLists(lists, startIndex, middleIndex);
        ListNode *l2 = mergeKLists(lists, middleIndex + 1, endIndex);

        return mergeTwoLists(l1, l2);
    }

    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) {

        ListNode pseudoHead(0);
        ListNode *p = &pseudoHead;

        while (l1 && l2) {
            if (l1->val <= l2->val) {
                p->next = l1;
                l1 = l1->next;
            } else {
                p->next = l2;
                l2 = l2->next;
            }
            p = p->next;
        }

        p->next = (l1 ? l1 : l2);

        return pseudoHead.next;
    }
};

int main() {

    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(5);

    ListNode *l2 = new ListNode(1);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(4);

    ListNode *l3 = new ListNode(2);
    l3->next = new ListNode(6);

    vector<ListNode *> inputs = {l1, l2, l3};

    ListNode* result = Solution().mergeKLists(inputs);

    return 0;
}
