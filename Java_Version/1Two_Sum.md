* Given an array of integers, return indices of the two numbers such that they add up to a specific target.

  You may assume that each input would have exactly one solution, and you may not use the same element twice.



*  Example:
  
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,

  return [0, 1].*/



* 思想：

* 顺序遍历数组，对于每个元素将当前元素放在HashMap中，判断 target与当前元素的差是否在 HashMap中