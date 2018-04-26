/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Write a function to find the longest common prefix string amongst an array of strings.*/


import java.lang.System;


public class Main
{
    public static void main(String[] args)
    {
        String[] input = {"a", "b"};

        Solution solution = new Solution();

        String receiveFlag = solution.longestCommonPrefix(input);

        System.out.println("haha");
    }


}


class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length < 1)
        {
            return "";
        }
        else if (strs.length == 1)
        {
            return strs[0];
        }


        int minLength = this.findMinLength(strs);
        String prefix = strs[0].substring(0,minLength);
        for ( int index = 1; index < strs.length; index++  )
        {
            while (true)
            {
                if ( strs[index].indexOf(prefix) != 0 )
                {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
                else
                {
                    break;
                }
            }
        }

        return prefix;
    }


    private int findMinLength(String[] strs)
    {
        int strsLength = strs.length;


        int minLength = strs[0].length();
        for (int index = 0; index < strsLength; index++ )
        {
            if ( strs[index].length() < minLength )
            {
                minLength = strs[index].length();
            }
        }

        return minLength;
    }
}