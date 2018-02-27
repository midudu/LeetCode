* Given a string, find the length of the longest substring without repeating characters.


* 

* Example

  Given "abcabcbb", the answer is "abc", which the length is 3.

  Given "bbbbb", the answer is "b", with the length of 1.

  Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.



* 
* 
* 思想：

* (1) 顺序遍历String，将当前字符放进 HashMap 中

* (2) 有两个变量 startIndex和i，startIndex代表不重复子字符串区间的左端，i代表当前的字符，即区间的右端

* (3) 如果当前字符在 HashMap 中，说明 左端点应该至少在 HashMap中已经保存的与当前字符重复的那个位置的下一个位置，但是也有可能出现一种糟糕的情况，如 "abccea",当前字符为a，它对应的重复字符在位置0，但是不重复子字符串应该起始于位置3，所以应该取两者最大值，即更靠右的端点

----
    startIndex = Math.max(characterIntegerHashMap.get( new Character(s.charAt(i)) ) + 1, startIndex);

* (4) 每次求取区间长度 i - startIndex + 1，作为可能的返回值，注意 +1

----
    result = Math.max(result, i - startIndex + 1);