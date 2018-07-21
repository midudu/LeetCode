/* 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空） */

/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        
        if ( pHead == null ) {
            
            return null;
        }
        
        RandomListNode needleNode = pHead;
        
        while ( needleNode != null ) {
            
            RandomListNode nextNode = needleNode.next;
            needleNode.next = new RandomListNode(needleNode.label);
            needleNode.next.next = nextNode;
            
            needleNode = needleNode.next.next;
        }
        
        RandomListNode oldNode = pHead;
        RandomListNode newNode = pHead.next;
        
        while (newNode != null) {
            if (oldNode.random != null) {
                newNode.random = oldNode.random.next;
            }
            if ( oldNode.next != null ) {
                oldNode = oldNode.next.next;
            } else {
                break;
            }
            
            if ( newNode.next != null ) {
                newNode = newNode.next.next;
            } else {
                break;
            }
            
        }
        
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        RandomListNode pCur = pHead;
        
        while( pCur != null ){
            pCur.next = pCur.next.next;
            if(cur.next!=null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;  
    }
}