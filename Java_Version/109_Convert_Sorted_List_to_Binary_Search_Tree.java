/*
  Given a singly linked list where elements are sorted in ascending order,
convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in
which the depth of the two subtrees of every node never differ by more than 1.

Example:

  Given the sorted linked list: [-10,-3,0,5,9],

  One possible answer is: [0,-3,9,-10,null,5], which represents the following
height balanced BST:

          0
         / \
       -3   9
       /   /
     -10  5
*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public static void main(String[] args) {

        int[] input = {-10, -3, 0, 5, 9};
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = new Solution().sortedListToBST(head);

        System.out.print("");
    }

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        return sortedListToBSTHelper(head);
    }

    private TreeNode sortedListToBSTHelper(ListNode head) {

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        } else if (head.next.next == null) {
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }

        ListNode middleListNode = findMiddleListNode(head);
        ListNode nextNode = middleListNode.next;
        middleListNode.next = null;

        TreeNode root = new TreeNode(nextNode.val);
        root.left = sortedListToBSTHelper(head);
        root.right = sortedListToBSTHelper(nextNode.next);

        return root;
    }

    private ListNode findMiddleListNode(ListNode head) {

        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;
        ListNode slowPointer = head, fastPointer = head, pseudoSlowPointer = pseudoHead;

        while (fastPointer != null && fastPointer.next != null) {

            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            pseudoSlowPointer = pseudoSlowPointer.next;
        }

        return pseudoSlowPointer;
    }
}
