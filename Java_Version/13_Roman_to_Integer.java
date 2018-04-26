/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given a roman numeral, convert it to an integer.Given a roman numeral, convert it to an integer.

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
    public int romanToInt(String s) {

        if ( s == null || s.length() == 0)
        {
            return 0;
        }

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>(10);
        this.putHashMap(hashMap);

        if ( s.length() == 1)
        {
            return hashMap.get(s.charAt(0)).intValue();
        }


        return romanToIntForLengthMoreThanOne(s, hashMap);
    }

    private void putHashMap(HashMap<Character, Integer> hashMap)
    {
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
    }

    private int romanToIntForLengthMoreThanOne(String s, HashMap<Character, Integer> hashMap)
    {
        int sLength = s.length();

        int returnValue = new Integer(0);

        for (int i = 0; i < sLength - 1; i++)
        {
            int currentValue = hashMap.get(s.charAt(i)).intValue();
            int nextValue = hashMap.get(s.charAt(i+1)).intValue();

            if ( currentValue < nextValue )
            {
                returnValue -= currentValue;
            }
            else
            {
                returnValue += currentValue;
            }
        }

        returnValue += hashMap.get(s.charAt(sLength - 1)).intValue();

        return returnValue;
    }
}