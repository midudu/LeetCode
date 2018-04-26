/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a linked list, determine if it has a cycle in it.

  Follow up:
  
  Can you solve it without using extra space?*/


 
* 
* 思想：

* (1) 快慢指针思想：快指针一次前进两步，慢指针一次前进一步，如果链表中存在环，那么快指针一定能追上慢指针

* (2) 关于while循环的终止条件：可以直接用 while( fastPointer != null && fastPointer.next != null)，因为fastPointer一旦是null，说明链表一定不存在环，因为环形链表是不存在null的