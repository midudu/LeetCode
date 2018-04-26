/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
 [
  [-1, 0, 1],
  [-1, -1, 2]
  ]


 
* 
* 思想：

* (1) 暴力循环的复杂度是O(n^3)，用双指针的方式可以把复杂度降为O(n^2)，具体方法是先对数组进行排序。一个变量用作循环变量i遍历数组，另外两个指针一个指向i+1，一个指针指向 length-1，判断三个数的和与0的关系，如果大于0，则向左移动尾指针；小于0，则向右移动头指针；

* (2) 为了防止输出重复结果，对于3个变量都要跳过重复元素；

* ！！！跳过重复元素的方法是

----
    if ( i > 0 && nums[i] == nums[i-1] ) [
        continue;
    }
即这样操作之后取的是一组重复序列的第一个数

* (3) 当数组长度较长时，可以首先判断特殊情况（如本次循环可能得到的最小值是否已经大于0 或 最大值是否已经小于0），减少循环次数；

* (4) 核心思想即尽量减少循环次数