/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4*/


 
* 
* 思想：

* (1) 双指针思想：两个指针分别指向两个链表的头节点，当两个指针均不指向null时循环继续；有任何一个指针指向null后，直接把新生成链表的当前指针指向非null的另一个链表

* (2) 添加伪头节点，方便书写


