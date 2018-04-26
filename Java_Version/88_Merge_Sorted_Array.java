/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

  Note:
    You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
    The number of elements initialized in nums1 and nums2 are m and n respectively.*/


import java.lang.System;
import java.util.*;
import java.lang.Math;


public class Main
{
    public static void main(String[] args)
    {
        int[] nums1 = {0,8,10};
        int[] nums2 = {1};

        Solution solution = new Solution();

        solution.merge(nums1,0, nums2,1);

        System.out.println("haha");

    }


}


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int mergePointer = m + n - 1;
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;

        while ( nums1Pointer >= 0 && nums2Pointer >= 0 )
        {
            if (nums1[nums1Pointer] > nums2[nums2Pointer])
            {
                nums1[mergePointer] = nums1[nums1Pointer];
                nums1Pointer--;
            }
            else
            {
                nums1[mergePointer] = nums2[nums2Pointer];
                nums2Pointer--;
            }

            mergePointer--;
        }

        if ( nums1Pointer < 0 )
        {
            for (int i = 0; i <= nums2Pointer; i++)
            {
                nums1[i] = nums2[i];
            }
        }

    }
}