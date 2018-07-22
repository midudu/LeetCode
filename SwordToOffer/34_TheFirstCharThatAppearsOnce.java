/* 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）. */

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        
        if ( str == null || str.length() == 0 ) {
            return -1;
        }
        
        int[] charsCount = new int[256];
        int[] charsIndex = new int[256];
        
        for (int i = 0; i < str.length(); i++) {
            
            char currentChar = str.charAt(i);
            
            if ( charsCount[currentChar] == 0 ) {
                charsIndex[currentChar] = i;
            }
            
            charsCount[currentChar]++;
        }
        
        char startIndex = ('a' < 'A') ? 'a':'A';
        char endIndex = ('z' > 'Z') ? 'z' : 'Z';
        int result = -1;
        for (char i = startIndex; i <= endIndex; i++) {
            
            if (charsCount[i] == 1) {
                if ( result == -1 ) {
                    result = charsIndex[i];
                } else {
                    result = Math.min(result, charsIndex[i]);
                }
            }
        }
        
        return result;
    }
}