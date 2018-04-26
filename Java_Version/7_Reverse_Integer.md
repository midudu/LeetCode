/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

* Given a 32-bit signed integer, reverse digits of an integer.


* Example 1:

   Input: 123

   Output:  321

*  Example 2:

  Input: -123
 
 Output: -321
 
* Example 3:

  Input: 120
  
  Output: 21

* Note:

Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 
* 
* 思想：

* (1) 将整数逆序输出，也就是逐次对10取余，不断除10 并且 进行移位相加

* (2) 负数取余的结果是将负数取绝对值后取余，然后添上负号，也就是每次直接对负数取余即可，不需要考虑负数的问题

* (3) 判断逆序后是否溢出范围的方法非常巧妙：新的结果应该等于 上次的结果*10+这次取余的结果，
* 
* 判断溢出的方法是如果没有发生溢出，那么上面的过程应该是可逆的，即 （新的结果 - 这次取余的结果）/10应该等于上次的结果，如果不等，说明发生了溢出（事实上，由于这次取余的结果一定小于10，所以直接比较 新的结果/10 和 上次的结果 即可)