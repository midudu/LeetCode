/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

* Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

  Note:
  You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.The number of elements initialized in nums1 and nums2 are m and n respectively.


 
* 
* 思想：

* (1) 巧妙之处在于要**从后向前**写数组，这样就不用创建新数组，也不用担心数据覆盖的问题，因为一个元素新的位置一定大于等于原位置

* (2) 另一个巧妙之处在于当两个Pointer中至少有一个小于0以后，即一个数组已经完全merge，只需要判断nums2是否未完全merge，因为nums1是最终要输出的数组，未merge的数据直接保持原有位置不变即可