/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

  Substrings that occur multiple times are counted the number of times they occur.

   Example 1:
   
Input: "00110011"

 Output: 6

  Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

  Notice that some of these substrings repeat and are counted the number of times they occur.

  Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.

  Example 2:

   Input: "10101"

   Output: 4

   Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
   
   Note:

   s.length will be between 1 and 50,000.
   s will only consist of "0" or "1" characters.


 
* 
* 思想：

* (1) 首先，到底有多少个这样的子串存在取决于有多少个连续的1或0，“111001111”说明可以形成2+2=4个子串
* 
* (2) 遍历一次就可以得到结果，要注意的是 结尾处残余子串不要忘记加了

