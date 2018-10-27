/*
Given a set of candidate numbers (candidates) (without duplicates)
and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

        Example 1:

        Input: candidates = [2,3,6,7], target = 7,
        A solution set is:
        [
        [7],
        [2,2,3]
        ]

        Example 2:

        Input: candidates = [2,3,5], target = 8,
        A solution set is:
        [
        [2,2,2,2],
        [2,3,3],
        [3,5]
        ]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) throws InterruptedException{

        int[] candidates = {2,3,5};
        int target = 8;

        List<List<Integer>> result = new Solution().combinationSum(candidates, target);

        Thread.sleep(1000);
    }


    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        ArrayList<Integer> list = new ArrayList<>();
        combinationSumHelper(candidates, target, candidates.length, list);

        return result;
    }

    private void combinationSumHelper(int[] candidates, int target, int endIndex,
                                      ArrayList<Integer> existingCandidates) {

        int index = Arrays.binarySearch(candidates, 0, endIndex, target);
        if (index >= 0) {

            List<Integer> existingCandidatesCopy = new ArrayList<Integer>(existingCandidates);
            existingCandidatesCopy.add(candidates[index]);
            result.add(existingCandidatesCopy);
        }

        int insertIndex = (index >= 0 ? index : -index - 1);
        for (int i = insertIndex - 1; i >= 0; i--) {

            existingCandidates.add(candidates[i]);

            combinationSumHelper(candidates, target - candidates[i],
                    i + 1, existingCandidates);

            existingCandidates.remove(existingCandidates.size()-1);
        }
    }
}