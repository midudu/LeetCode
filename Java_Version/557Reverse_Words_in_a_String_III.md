/*Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 
  Example 1:

   Input: "Let's take LeetCode contest"

   Output: "s'teL ekat edoCteeL tsetnoc"

   Note: In the string, each word is separated by single space and there will not be any extra space in the string.*/


 
* 
* 思想：

* (1) 一种比较慢的方法是用 String.split()、 StringBuilder.reverse()、 StringBuilder.append()函数写代码比较短
*
* (2) 一种比较快的方法是先把String转化为 char[] ，直接对数组逐位进行操作，然后把 char[]再转化为String 
