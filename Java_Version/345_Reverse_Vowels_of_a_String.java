/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Write a function that takes a string as input and reverse only the vowels of a string.

        Example 1:
        Given s = "hello", return "holle".

        Example 2:
        Given s = "leetcode", return "leotcede".

        Note:
        The vowels does not include the letter "y".*/


import java.lang.System;


public class Main
{
    public static void main(String[] args)
    {
        String input1 = "OP";

        Solution solution = new Solution();

        String receiveFlag = solution.reverseVowels(input1);

        System.out.println(receiveFlag);
    }


}


class Solution {
    public String reverseVowels(String s) {

        if (s.isEmpty())
        {
            return s;
        }

        StringBuilder stringBuilderLower = new StringBuilder(s.toLowerCase());
        StringBuilder stringBuilder = new StringBuilder(s);

        int startIndex = 0;
        int endIndex = stringBuilder.length() - 1;

        while ( startIndex < endIndex )
        {
            startIndex = this.FindStartIndex(stringBuilderLower, startIndex, endIndex);
            endIndex = this.FindEndIndex(stringBuilderLower, startIndex, endIndex);

            if ( startIndex < endIndex )
            {
                char startChar = stringBuilder.charAt(startIndex);
                char endChar = stringBuilder.charAt(endIndex);

                stringBuilder.setCharAt(startIndex,endChar);
                stringBuilder.setCharAt(endIndex,startChar);

                startIndex++;
                endIndex--;
            }
        }

        return stringBuilder.toString();
    }

    private int FindStartIndex(StringBuilder stringBuilder, int startIndex, int endIndex)
    {
        while ( startIndex < endIndex )
        {
            if ( "aeiou".indexOf( stringBuilder.charAt(startIndex) ) == -1 )
            {
                startIndex++;
            }
            else
            {
                break;
            }
        }

        return startIndex;
    }

    private int FindEndIndex(StringBuilder stringBuilder, int startIndex, int endIndex)
    {
        while (startIndex < endIndex )
        {
            if ( "aeiou".indexOf( stringBuilder.charAt(endIndex) ) == -1 )
            {
                endIndex--;
            }
            else
            {
                break;
            }
        }

        return endIndex;
    }
}