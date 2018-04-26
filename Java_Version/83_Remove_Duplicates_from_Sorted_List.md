/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,

 Given 1->1->2, return 1->2.

 Given 1->1->2->3->3, return 1->2->3.*/


 
* 
* 思想：

* (1) 双指针，快指针负责遍历整个原始链表，慢指针负责“穿针引线”缝合新的链表

* (2) 易错点 是 最后慢指针需要指向 null，这样链表才完整
