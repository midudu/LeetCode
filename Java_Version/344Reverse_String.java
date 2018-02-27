/*Write a function that takes a string as input and returns the string reversed.

        Example:
        Given s = "hello", return "olleh".*/


import java.lang.System;


public class Main
{
    public static void main(String[] args)
    {
        String input1 = "aba";
        String input2 = "hello";

        Solution solution = new Solution();

        String receiveFlag = solution.reverseString(input2);

        System.out.println(receiveFlag);
    }


}


class Solution {
    public String reverseString(String s) {

        StringBuilder stringBuilder = new StringBuilder(s);

        return stringBuilder.reverse().toString();
    }
}