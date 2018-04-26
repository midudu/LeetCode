/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

  Note:
   0 ≤ x, y < 231.

  Example:

        Input: x = 1, y = 4

        Output: 2

        Explanation:
        1   (0 0 0 1)
        4   (0 1 0 0)
        ↑   ↑

        The above arrows point to positions where the corresponding bits are different.*/
 
* 
* 思想：

* (1) 异或两个数，调用 Integer.bitCount(int)函数

----
    