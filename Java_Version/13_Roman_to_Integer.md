/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

* Given a roman numeral, convert it to an integer.Given a roman numeral, convert it to an integer.

  Input is guaranteed to be within the range from 1 to 3999.


 
* 
* 思想：

* (1) 提前写好对应关系的HashMap<Character, Integer>


* (2) 按照 左大右小为加，左小右大为减 的原则决定每一位的符号
