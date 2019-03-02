/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to
target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,

        A solution set is:
        [
        [1, 7],
        [1, 2, 5],
        [2, 6],
        [1, 1, 6]
        ]

Example 2:

        Input: candidates = [2,5,2,1,2], target = 5,

        A solution set is:
        [
        [1,2,2],
        [5]
        ]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0
                || target <= 0) {

            return new ArrayList<>();
        }

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> existingCandidates = new ArrayList<>();

        combinationSum2Helper(candidates, target, 0,
                existingCandidates, result);

        return result;
    }

    private void combinationSum2Helper(
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

            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            existingCandidates.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i],
                    i + 1, existingCandidates, result);
            existingCandidates.remove(existingCandidates.size() - 1);
        }
    }
}