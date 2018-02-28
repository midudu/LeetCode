* Given an array and a value, remove all instances of that value in-place and return the new length.

  Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

  The order of elements can be changed. It doesn't matter what you leave beyond the new length.
* 

* Example:

  Given nums = [3,2,2,3], val = 3,

  Your function should return length = 2, with the first two elements of nums being 2.


 
* 
* 思想：

* (1) 双指针，一个指针A指向当前元素，另一个指针B指向满足条件的已存储元素的最右端

* (2) 巧妙之处是 指针B 的位置用于小于等于指针A的位置，而且直接将B的位置+1作为返回值