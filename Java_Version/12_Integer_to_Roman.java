/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an integer, convert it to a roman numeral.

        Input is guaranteed to be within the range from 1 to 3999.*/


import java.lang.System;
import java.util.HashMap;


public class Main
{
    public static void main(String[] args)
    {
        /*String[] input = {"a", "b"};

        Solution solution = new Solution();

        String receiveFlag = solution.longestCommonPrefix(input);

        System.out.println("haha");*/

    }


}


class Solution {
    public String intToRoman(int num) {

        String[] thousand = {"", "M", "MM", "MMM" };
        String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int thousandBit = num / 1000;
        int hundredBit = (num % 1000)/100;
        int tenBit = (num % 100) / 10;
        int oneBit = (num % 10);

        return thousand[thousandBit] + hundred[hundredBit] + ten[tenBit] + one[oneBit];
    }
}