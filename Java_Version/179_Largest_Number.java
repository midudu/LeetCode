/*
Given a list of non negative integers, arrange them such that they form the largest number.

        Example 1:

        Input: [10,2]
        Output: "210"
        Example 2:

        Input: [3,30,34,5,9]
        Output: "9534330"
        Note: The result may be very large, so you need to return a string instead of an integer.*/

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public String largestNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return "";
        }

        String[] numsString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsString[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsString, new NewComparator());

        if (numsString[numsString.length - 1].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int i = numsString.length - 1; i >= 0; i--) {
            result.append(numsString[i]);
        }

        return result.toString();
    }
}

class NewComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {

        String s1 = o1 + o2;
        String s2 = o2 + o1;

        return s1.compareTo(s2);
    }
}