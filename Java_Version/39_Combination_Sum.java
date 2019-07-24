/*
  Given a set of candidate numbers (candidates) (without duplicates) and a
target number (target), find all unique combinations in candidates where the
candidate numbers sums to target.

  The same repeated number may be chosen from candidates unlimited number of
times.

Note:

  All numbers (including target) will be positive integers. The solution set
must not contain duplicate combinations.

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

    public static void main(String[] args) {

        int[] candidates = {2,3,5};
        int target = 8;

        List<List<Integer>> result = new Solution().combinationSum(candidates, target);

        System.out.println();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        List<Integer> currentResult = new ArrayList<>();

        combinationSumHelper(candidates, target, 0, result, currentResult);

        return result;
    }

    private void combinationSumHelper(
            int[] candidates, int target, int startIndex,
            List<List<Integer>> result, List<Integer> existingNums) {

        if (target == 0) {
            List<Integer> currentResultCopy = new ArrayList<>(existingNums);
            result.add(currentResultCopy);
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            if (candidates[startIndex] > target) {
                break;
            }

            existingNums.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i],
                    i, result, existingNums);
            existingNums.remove(existingNums.size() - 1);
        }
    }
}
