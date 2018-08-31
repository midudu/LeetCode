/* 
请实现一个函数用来匹配包括'.'和'*'的正则表达式。

模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（包含0次）。 

在本题中，匹配是指字符串的所有字符匹配整个模式。
例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
但是与"aa.a"和"ab*a"均不匹配 */

public class Solution {
    public boolean match(char[] str, char[] pattern) {
		
		if ( pattern == null || pattern.length == 0 ) {
			
			if ( str == null || str.length == 0 ) {
			    return true;
		    } else {
				return false;
			}
		}
		
		return matchHelper(str, 0, str.length, pattern, 0, pattern.length);
    }
	
	private boolean matchHelper(char[] str, int i, int length1, 
	                            char[] pattern, int j, int length2) {
									
        if( i == length1 && j == length2) {
            return true;
        }
		
        if( i == length1 && j != length2) {
			
            while( j != length2) {
				
                if( pattern[j] != '*' && ( j+1 >= length2 || pattern[j+1] != '*' ) ) {
                    return false;
                }
                j++;
            }
            return true;
        }
		
		if( i != length1 && j == length2 ) {
            return false;
        }
		
        if( j + 1 == length2) {
			
            if( str[i] == pattern[j] || pattern[j]=='.') {
				return matchHelper(str, i + 1, length1, pattern, j + 1, length2);
			} else {
                return false;
            }
        }
		
        if( (str[i] == pattern[j] || pattern[j]=='.')
			&& pattern[j+1] != '*') } {
			
			return matchHelper(str, i + 1, length1, pattern, j + 1, length2);
		}
            
        if( (str[i] == pattern[j] || pattern[j]=='.')
			&& pattern[j+1] == '*') {
			
			return matchHelper(str, i, length1, pattern, j + 2, length2)
			     ||matchHelper(str, i + 1, length1, pattern, j, length2);
		}
            
        if( pattern[j + 1] == '*') {
			return matchHelper(str, i, length1, pattern, j + 2, length2);
		}
        
		return false;
    }
}