/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

        For example,
        "A man, a plan, a canal: Panama" is a palindrome.
        "race a car" is not a palindrome.

        Note:
        Have you consider that the string might be empty? This is a good question to ask during an interview.

        For the purpose of this problem, we define empty string as valid palindrome.*/

import java.lang.System;


public class Main
{
    public static void main(String[] args)
    {
        String string = "ab";

        Solution solution = new Solution();

        boolean receiveFlag = solution.isPalindrome(string);

        System.out.println(receiveFlag);
    }


}


class Solution {
    public boolean isPalindrome(String s) {

        if (s.isEmpty())
        {
            return true;
        }

        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        String reverseS = new StringBuilder(s).reverse().toString();

        return (s.equals(reverseS));
    }
}