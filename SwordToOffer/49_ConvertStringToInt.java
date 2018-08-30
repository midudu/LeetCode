/* 题目描述

将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，

要求不能使用字符串转换整数的库函数。 
数值为0或者字符串不是一个合法的数值则返回0。

输入描述:
输入一个字符串,包括数字字母符号,可以为空

输出描述:
如果是合法的数值表达则返回该数字，否则返回0

示例1
输入

+2147483647
    1a33
输出

2147483647
    0 */

public class Solution {
	
    public int StrToInt(String str) {
        
		if ( str == null || str.length() == 0 ) {
			return 0;
		}
		
		int positiveFlag = checkPositiveOrNegative(str);
		if ( positiveFlag == 0 ) {
			return 0;
		} else if ( positiveFlag == -1 ) {
			return strToNegativeInt(str);
		} else {
			if ( str.charAt(0) == '+' ) {
				return strToPositiveInt(str, 1);
			} else {
				return strToPositiveInt(str, 0);
			}
		}
    }
	
	private int checkPositiveOrNegative(String str) {
		
		char firstChar = str.charAt(0);
		
		if (firstChar == '+') {
			if ( str.length() > 1 ) {
				return 1;
			} else {
				return 0;
			}
			
		} else if ( firstChar == '-' ) {
			
			if ( str.length() > 1 ) {
				return -1;
			} else {
				return 0;
			}
			
		} else if ( firstChar >= '1' && firstChar <= '9' ) {
			return 1;
		} else if ( firstChar == '0' ) {
			if ( str.length() == 1 ) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	private int strToNegativeInt(String str) {
		
		int result = 0;
		
		for (int i = 1; i < str.length(); i++ ) {
			
			char currentChar = str.charAt(i);
			if ( currentChar >= '0' && currentChar <= '9' ) {
				result *= 10;
				result -= (currentChar - '0');
				
			} else {
				return 0;
			}
		}
		
		return result;
	}
	
	private int strToPositiveInt(String str, int startIndex) {
		
		int result = 0;
		
		for ( int i = startIndex; i < str.length(); i++ ) {
			
			char currentChar = str.charAt(i);
			
			if ( currentChar >= '0' && currentChar <= '9' ) {
				result *= 10;
				result += (currentChar - '0');
				
			} else {
				return 0;
			}
		}
		
		return result;
	}
}