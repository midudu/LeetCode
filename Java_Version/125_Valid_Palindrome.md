/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
* 
* For example,
   "A man, a plan, a canal: Panama" is a palindrome.
   "race a car" is not a palindrome.

* Note:
   Have you consider that the string might be empty? This is a good question to ask during an interview.

   For the purpose of this problem, we define empty string as valid palindrome.


 
* 
* 思想：

* (1) 巧妙之处在于要**从后向前**写数组，这样就不用创建新数组，也不用担心数据覆盖的问题，因为一个元素新的位置一定大于等于原位置

* (2) 另一个巧妙之处在于当两个Pointer中至少有一个小于0以后，即一个数组已经完全merge，只需要判断nums2是否未完全merge，因为nums1是最终要输出的数组，未merge的数据直接保持原有位置不变即可