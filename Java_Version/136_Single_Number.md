/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/


 
* 
* 思想：

* (1) 一个数跟自己异或结果为0，把所有数异或一遍得到的结果就是 那个单个的值了