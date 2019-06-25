/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

        Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

        Example 1:
        Input: [1, 2, 2, 3, 1]
        Output: 2
        Explanation:
        The input array has a degree of 2 because both elements 1 and 2 appear twice.
        Of the subarrays that have the same degree:
        [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
        The shortest length is 2. So return 2.
        Example 2:
        Input: [1,2,2,3,1,4,2]
        Output: 6
        Note:

        nums.length will be between 1 and 50,000.
        nums[i] will be an integer between 0 and 49,999.*/

import java.util.Arrays;
import java.lang.Math;
import java.lang.System;
import java.util.HashMap;
import java.lang.Integer;
import java.util.Iterator;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 2};

        Solution solution = new Solution();
        int receive = solution.findShortestSubArray(nums);


        System.out.println("haha");
    }

}


class Solution {
    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, int[]> hashMap = new HashMap<>();

        int numsLength = nums.length;
        Integer lastCount = 0;

        for (int i = 0; i < numsLength; i++) {

            if (hashMap.containsKey(nums[i])){
                int[] currentNumber = {hashMap.get(nums[i])[0] + 1, hashMap.get(nums[i])[1], i};
                hashMap.replace(nums[i], currentNumber);
            } else {
                int[] currentNumber = {1, i, i};
                hashMap.put(nums[i], currentNumber);
            }

        }

        int maxFrequency = 0;
        int currentFrequency = 0;
        int maxNumber = -1;
        int returnValue = numsLength;
        int currentReturnValue = 0;
        int currentNumber = 0;
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            currentFrequency = ((int [])entry.getValue())[0];
            if (currentFrequency>maxFrequency){
                maxFrequency = currentFrequency;
                maxNumber = (Integer) entry.getKey();
                returnValue = hashMap.get(maxNumber)[2] - hashMap.get(maxNumber)[1] + 1;
            } else if ( currentFrequency == maxFrequency ){
                currentNumber = (Integer) entry.getKey();
                currentReturnValue = hashMap.get(currentNumber)[2] - hashMap.get(currentNumber)[1] + 1;
                if (currentReturnValue<returnValue){
                    returnValue = currentReturnValue;
                }
            }
        }
        return returnValue;
    }
}