/*Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


 American keyboard


 Example 1:
 
 Input: ["Hello", "Alaska", "Dad", "Peace"]

  Output: ["Alaska", "Dad"]

   Note:

   You may use one character in the keyboard more than once.

  You may assume the input string will only contain letters of alphabet.*/

 
* 
* 思想：

* (1) 把键盘的每一行字母存到 一个 hashmap 中，遍历每个String
