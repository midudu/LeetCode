/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

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


    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        ArrayList<Integer> existingCandidates = new ArrayList<>();

        combinationSum2Helper(candidates, target, candidates.length - 1,
                existingCandidates);

        return result;
    }

    private void combinationSum2Helper(
            int[] candidates, int target, int endIndex,
            ArrayList<Integer> existingCandidates) {

        if (target == 0) {
            ArrayList<Integer> existingCandidatesCopy
                    = new ArrayList<>(existingCandidates);
            this.result.add(existingCandidatesCopy);
            return;
        }

        int index = findFirstLessThanOrEqualToTargetIndex(
                candidates, target, endIndex);
        if (index < 0) {
            return;
        }

        for (int i = index; i >= 0; i--) {

            if (i != candidates.length - 1 && i != index) {
                if (candidates[i] == candidates[i + 1]) {
                    continue;
                }
            }

            existingCandidates.add(candidates[i]);

            combinationSum2Helper(candidates, target - candidates[i], i - 1,
                    existingCandidates);

            existingCandidates.remove(existingCandidates.size() - 1);
        }
    }

    private int findFirstLessThanOrEqualToTargetIndex(
            int[] candidates, int target, int endIndex) {

        if (endIndex == 0) {
            return (candidates[0] <= target ? 0 : -1);
        }

        int startIndex = 0;

        while (startIndex <= endIndex) {

            if (startIndex == endIndex) {
                return (candidates[startIndex] <= target ? startIndex : -1);
            }

            if (startIndex + 1 == endIndex) {
                if (candidates[endIndex] <= target) {
                    return endIndex;
                } else {
                    return (candidates[startIndex] <= target ? startIndex : -1);
                }
            }

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (candidates[middleIndex] <= target) {
                startIndex = middleIndex;
            } else {
                endIndex = middleIndex - 1;
            }
        }

        return -1;
    }
}