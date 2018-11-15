/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

        Example:

        Input: n = 4, k = 2
        Output:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combine(int n, int k) {

        if (n <= 0 || k <= 0) {
            return new ArrayList<>();
        }

        k = (k > n ? n : k);

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        List<List<Integer>> result = new ArrayList<>();
        combineHelper();
    }

    private void combineHelper(
            int[] nums, int startIndex, int k,
            ArrayList<Integer> currentList, List<List<Integer>> result) {


    }
}