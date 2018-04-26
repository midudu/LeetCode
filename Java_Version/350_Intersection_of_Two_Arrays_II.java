/*
Given two arrays, write a function to compute their intersection.

        Example:
        Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

        Note:
        Each element in the result should appear as many times as it shows in both arrays.
        The result can be in any order.
        Follow up:
        What if the given array is already sorted? How would you optimize your algorithm?
        What if nums1's size is small compared to nums2's size? Which algorithm is better?
        What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/


import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test {
    public static void main(String[] args) {

        String s = "egg", t = "add";

        new Solution().isPowerOfThree(27);
    }
}


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int firstPointer = 0, secondPointer = 0;
        List<Integer> resultList = new ArrayList<Integer>();

        while (firstPointer < nums1.length
                && secondPointer < nums2.length) {

            if (nums1[firstPointer] > nums2[secondPointer]) {
                secondPointer++;
            } else if (nums1[firstPointer] < nums2[secondPointer]) {
                firstPointer++;
            } else {
                resultList.add(nums1[firstPointer]);
                firstPointer++;
                secondPointer++;
            }
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}