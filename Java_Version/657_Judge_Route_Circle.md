/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

* Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

 The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

*       Example 1:
 
  Input: "UD"

  Output: true

*       Example 2:
 
  Input: "LL"

  Output: false


 
* 
* 思想：

* (1) 首先将 String 转化为 char[]
* 
* (2) 初始化一个记录各个元素出现个数的数组

---
    int[] temp=new int[128];

* (3) 遍历char[]数组，将元素出现的个数记录在temp数组中

----

    for(char i:moves.toCharArray()){
         temp[i]++;
    }

* (4) 最后判断的是 L、R出现次数是否相等以及U、D出现次数是否相等

----

    return ( temp['R']==temp['L'] && temp['U'] ==temp['D'] );

* (5) 这种遍历String的问题一般都是先用 .toCharArray() 转化为char[]再处理

* (6) 巧妙之处一是使用字符作为索引（由于字母一定出现在0-255范围内，且不重复；

二是对于上下/左右 两个维度上的事情，只使用了一个数组进行判断，减小开销