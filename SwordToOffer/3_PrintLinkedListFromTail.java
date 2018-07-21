/* 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。 */

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
public class Solution {
    
    private ArrayList<Integer> result;
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        
        result = new ArrayList<>();
        
        printListFromTailToHeadHelper(listNode);
        
        return result;
    }
    
    private void printListFromTailToHeadHelper(ListNode listNode) {
        
        if ( listNode == null ) {
            return;
        }
        
        printListFromTailToHeadHelper(listNode.next);
        result.add(listNode.val);
    }
}