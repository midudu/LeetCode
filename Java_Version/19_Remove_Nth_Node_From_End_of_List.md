/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
 Given n will always be valid.
 Try to do this in one pass.*/


 
* 
* 思想：

* (1) 前后指针思想，为了能一次遍历链表就得到答案，设置一个前指针先走n步，另一个后指针向不动，然后再让两个指针以同样的速度前进，当前指针到null时，删除后指针所在的位置即可

* (2) 设置 伪头结点，返回时返回 psudoHead.next即可

* (3) 不用开新结点也可以删除，下面的代码就把 原来tmp的下一个结点删除了

----
    
    tmp.next = tmp.next.next;        