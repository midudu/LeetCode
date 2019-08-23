/*
  Given an array of integers, find if the array contains any duplicates. Your
function should return true if any value appears at least twice in the array,
and it should return false if every element is distinct.
*/


import java.util.HashSet;

class Solution {

    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        int numsLength = nums.length;

        for (int i = 0; i < numsLength; i++) {
            if (hashSet.contains(nums[i])) {
                return true;
            }

            hashSet.add(nums[i]);
        }

        return false;
    }
}
