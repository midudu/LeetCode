/* 
输入一个字符串,按字典序打印出该字符串中字符的所有排列。

例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    
    private TreeSet<String> result = new TreeSet<>();
    
    public ArrayList<String> Permutation(String str) {
       
        if ( str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        
        char[] strArray = str.toCharArray();
        
        PermutationHelper(strArray, 0, "");
        
        ArrayList<String> sortedResult = new ArrayList<>();
        sortedResult.addAll(result);
        
        return sortedResult;
    }
    
    private void PermutationHelper(char[] strArray, int startIndex, String prefix) {
        
        if ( startIndex == strArray.length - 1 ) {
            result.add(prefix + new Character(strArray[startIndex]).toString());
            return;
        }
        
        char startChar = strArray[startIndex];
        
        for (int i = startIndex; i < strArray.length; i++) {
            
            if ( strArray[i] == startChar && i != startIndex) {
                continue;
            }
            
            strArray[startIndex] = strArray[i];
            strArray[i] = startChar;
            
            PermutationHelper(strArray, startIndex + 1, prefix + new Character(strArray[startIndex]).toString());
            
            strArray[i] = strArray[startIndex];
            strArray[startIndex] = startChar;
        }
    }
}
