/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:
        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/


import java.lang.System;
import java.util.*;
import java.lang.Math;
import java.util.HashMap;


public class Main
{
    public static void main(String[] args)
    {
        int[] nums1 = {2,7,11,15};
        int target = -1;

        Solution solution = new Solution();

        int[] receive = solution.twoSum(nums1, target);

        System.out.println("haha");

    }


}


class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for ( int i = 0; i < nums.length; i++ )
        {
            if ( hashMap.containsKey(new Integer(target - nums[i])) )
            {
                result[0] = hashMap.get(new Integer(target - nums[i])).intValue();
                result[1] = i;
                return result;
            }
            else
            {
                hashMap.put(new Integer(nums[i]), new Integer(i));
            }
        }

        return null;
    }
}