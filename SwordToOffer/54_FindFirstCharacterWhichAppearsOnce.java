/* 题目描述

请实现一个函数用来找出字符流中第一个只出现一次的字符。

例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。 */

import java.util.Stack;

public class Solution {
    
	private int[] appearenceCount = new int[256];
	int index = 1;
	
	//Insert one char from stringstream
	
    public void Insert(char ch) {
        
		if ( appearenceCount[ch] == 0 ) {
			appearenceCount[ch] = index;
			index++;
		} else {
			appearenceCount[ch] = -1;
		}
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
		
		char result = '#';
		int minIndex = Integer.MAX_VALUE;
		for ( int i = 0; i < appearenceCount.length; i++ ) {
			
			if ( appearenceCount[i] != -1 && appearenceCount[i] != 0
			&& appearenceCount[i] < minIndex ) {
				minIndex = appearenceCount[i];
				result = (char)i;
			}
		}
		
		return result;
    }
}