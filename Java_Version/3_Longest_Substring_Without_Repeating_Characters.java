/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a string, find the length of the longest substring without repeating characters.

        Examples:

        Given "abcabcbb", the answer is "abc", which the length is 3.

        Given "bbbbb", the answer is "b", with the length of 1.

        Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.*/


import java.lang.System;
import java.util.*;
import java.lang.Math;
import java.util.HashMap;


class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
    }
}



public class Main
{
    public static void main(String[] args)
    {
        String s = "bbbbb";

        Solution solution = new Solution();

        int receive = solution.lengthOfLongestSubstring(s);

        System.out.println("haha");

    }


}


class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<Character, Integer>();

        int sLength = s.length();
        int result = 0;
        int startIndex = 0;

        for ( int i = 0; i < sLength; i++ )
        {
            if ( characterIntegerHashMap.containsKey( new Character(s.charAt(i)) ) )
            {
                startIndex = Math.max(
                        characterIntegerHashMap.get( new Character(s.charAt(i)) ) + 1, startIndex);
            }

            characterIntegerHashMap.put(new Character(s.charAt(i)), new Integer(i));
            result = Math.max(result, i - startIndex + 1);

        }

        return result;
    }
}