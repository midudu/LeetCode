/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

* Write a function to find the longest common prefix string amongst an array of strings.


 
* 
* 思想：

* (1) 首先排除掉特殊情况

* (2) 将 strs[0]作为prefix，对于数组中的每一个String，如果它包括了prefix，继续下一个String；如果不包括，那么取prefix某位减1，直到包括prefix为止，退出循环