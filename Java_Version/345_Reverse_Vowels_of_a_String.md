/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

* Write a function that takes a string as input and reverse only the vowels of a string.
* 
* Example 1:
       
Given s = "hello", return "holle".

* Example 2:
  
Given s = "leetcode", return "leotcede".

* Note:
     
 The vowels does not include the letter "y".


 
* 
* 思想：

* (1) 双指针思想
* (2) 巧妙之处是先创建原因数组，可以加快查找速度,并且字符一定在0-255范围内

----
    boolean[] marked = new boolean[256];
        
    marked['u'] = true;
    marked['e'] = true;
    marked['o'] = true;
    marked['a'] = true;
    marked['i'] = true;
    marked['U'] = true;
    marked['E'] = true;
    marked['O'] = true;
    marked['A'] = true;
    marked['I'] = true;