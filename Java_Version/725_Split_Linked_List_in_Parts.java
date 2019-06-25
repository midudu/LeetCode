/*
  Given a (singly) linked list with head node root, write a function to split
the linked list into k consecutive linked list "parts".

  The length of each part should be as equal as possible: no two parts should
have a size differing by more than 1. This may lead to some parts being null.

  The parts should be in order of occurrence in the input list, and parts
occurring earlier should always have a size greater than or equal parts
occurring later.

  Return a List of ListNode's representing the linked list parts that are formed.

  Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]

Example 1:

        Input:
        root = [1, 2, 3], k = 5

        Output: [[1],[2],[3],[],[]]

        Explanation:

        The input and each element of the output are ListNodes, not arrays.
        For example, the input root has root.val = 1, root.next.val = 2,
      root.next.next.val = 3, and root.next.next.next = null.
        The first element output[0] has output[0].val = 1, output[0].next = null.
        The last element output[4] is null, but it's string representation as a
      ListNode is [].

Example 2:

        Input:
        root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3

        Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]

        Explanation:
        The input has been split into consecutive parts with size difference at
      most 1, and earlier parts are a larger size than the later parts.

Note:

        The length of root will be in the range [0, 1000].
        Each value of a node in the input will be an integer in the range [0, 999].
        k will be an integer in the range [1, 50].
*/

class ListNode {

    int val;

    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        ListNode pointer = root;

        for (int i = 2; i < 4; i++) {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }

        ListNode[] result = new Solution().splitListToParts(root, 5);

        System.out.println();
    }

    public ListNode[] splitListToParts(ListNode root, int k) {

        if (root == null) {
            return new ListNode[k];
        }

        int length = getLengthOfLinkedList(root);
        int avgSize = length / k;
        int leftSize = length - avgSize * k;

        ListNode[] result = new ListNode[k];

        ListNode currentRoot = root;

        for (int i = 0; i < k; i++) {

            int currentLength = avgSize;

            if (leftSize != 0) {
                leftSize--;
                currentLength++;
            }

            ListNode[] currentResult = getCurrentSegment(currentRoot, currentLength);

            result[i] = currentResult[0];
            currentRoot = currentResult[1];
        }

        return result;
    }

    private int getLengthOfLinkedList(ListNode root) {

        int result = 0;

        ListNode pointer = root;

        while (pointer != null) {
            result++;
            pointer = pointer.next;
        }

        return result;
    }

    private ListNode[] getCurrentSegment(ListNode root, int currentSize) {

        if (currentSize == 0) {
            return new ListNode[]{null, null};
        }

        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = root;

        ListNode pointer = pseudoHead;

        for (int i = 0; i < currentSize; i++) {
            pointer = pointer.next;
        }

        ListNode nextRoot = pointer.next;
        pointer.next = null;

        return new ListNode[]{pseudoHead.next, nextRoot};
    }
}