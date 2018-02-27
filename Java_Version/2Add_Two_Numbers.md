* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse 

order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

* 

* Example

  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 
  Output: 7 -> 0 -> 8
 
  Explanation: 342 + 465 = 807.*/



* 
* 
* 思想：

* (1) 设置进位，最后也要考虑

* (2) 首先创建 head和pointer，一个用于返回值，一个用于动态创建链表

  ------
    ListNode head = new ListNode(0);
    ListNode pointer = head;

* (3) 巧妙之处是 最终返回的是 head.next