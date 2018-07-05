/* 输入一个链表，反转链表后，输出新链表的表头。 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        
        ListNode lastNode = null;
        ListNode currentNode = head;
        
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = lastNode;
            
            lastNode = currentNode;
            currentNode = nextNode;
        }
        
        return lastNode;
    }
}