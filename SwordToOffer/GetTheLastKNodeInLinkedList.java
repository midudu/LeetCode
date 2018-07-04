/* 输入一个链表，输出该链表中倒数第k个结点。 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        
        if (k <= 0) {
            return null;
        }
        
        ListNode fastNode = head;
        ListNode slowNode = head;
        
        for (int i = 0; i < k; i++) {
            if (fastNode!=null) {
                fastNode = fastNode.next;
            } else {
                return null;
            }
        }
        
        while (fastNode!=null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        
        return slowNode;
    }
}