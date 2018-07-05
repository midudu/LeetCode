/* 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        
        ListNode psudoHead = new ListNode(0);
        ListNode temp = psudoHead;
        
        while ( pointer1 != null 
               && pointer2 != null ) {
            
            if ( pointer1.val <= pointer2.val ) {
                temp.next = pointer1;
                pointer1 = pointer1.next;
            } else {
                temp.next = pointer2;
                pointer2 = pointer2.next;
            }
            
            temp = temp.next;
        }
        
        if (pointer1 == null) {
            temp.next = pointer2;
        } else {
            temp.next = pointer1;
        }
        
        return psudoHead.next;
    }
}