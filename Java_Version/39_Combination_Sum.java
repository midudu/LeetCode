/*
Given a set of candidate numbers (candidates) (without duplicates) and a target
number (target), find all unique combinations in candidates where the candidate
numbers sums to target.

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
        ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0
                || target <= 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> existingCandidates = new ArrayList<>();

        combinationSumHelper(candidates, target, 0,
                existingCandidates, result);

        return result;
    }

    private void combinationSumHelper(
            int[] candidates, int target, int startIndex,
            List<Integer> existingCandidates, List<List<Integer>> result) {

        if (target == 0) {

            result.add(new ArrayList<>(existingCandidates));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            if (candidates[i] > target) {
                break;
            }

            existingCandidates.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], i,
                    existingCandidates, result);
            existingCandidates.remove(existingCandidates.size() - 1);
        }
    }
}