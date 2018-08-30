/* 
题目描述

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 

但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。 */

public class Solution {
    public boolean isNumeric(char[] str) {
        
		if ( str == null || str.length == 0 ) {
			return false;
		}
		
		int startIndex = calculateStartIndex(str);
		if ( startIndex == -1 ) {
			return false;
		}
		
		boolean eAllowableFlag = true;
		boolean minusAllowableFlag = true;
		boolean dotAllowableFlag = true;
		boolean addAllowableFlag = true;
		
		for ( int i = startIndex; i < str.length; i++ ) {
			
			char currentChar = str[i];
			
			if ( currentChar >= '0' && currentChar <= '9' ) {
				continue;
			} else if ( currentChar == 'e' || currentChar == 'E' ) {
				if ( eAllowableFlag ) {
					eAllowableFlag = false;
				} else {
					return false;
				}
			} else if ( currentChar == '-' ) {
				
				if ( eAllowableFlag ) {
					return false;
				} else {
					if ( minusAllowableFlag ) {
						minusAllowableFlag = false;
					} else {
						return false;
					}
				}
			} else if ( currentChar == '.' ) {
				if (!dotAllowableFlag) {
					return false;
				} else {
					dotAllowableFlag = false;
					
					if ( eAllowableFlag ) {
						if ( i ==  str.length - 1 || (!(str[i+1] >= '0' && str[i+1] <= '9')) ) {
							return false;
						}
					} else {
						return false;
					}
				}
				
			} else if ( currentChar == '+' ) {
				
				if (
				
			} else {
				return false;
			}
		}
		
		return true;
    }
	
	private int calculateStartIndex(char[] str) {
		
		if ( str[0] == '+' ) {
			if ( str.length == 1 ) {
				return -1;
			} else {
				return 1;
			}
		} else if ( str[0] == '-' ) {
			if ( str.length == 1 ) {
				return -1;
			} else {
				return 1;
			}
		} else if ( str[0] >= '1' && str[0] <= '9' ) {
			return 0;
		} else if ( str[0] == '0' ) {
			if ( str.length == 1 ) {
				return 0;
			} else {
				return -1;
			}
		}else {
			return -1;
		}
	}
}