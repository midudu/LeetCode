/*
Given two integers n and k, return all possible combinations of k numbers out
of 1 ... n.

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
        ]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        new Solution().combine(4,2);
    }

    public List<List<Integer>> combine(int n, int k) {

        if (n < 1 || k > n) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> currentResult = new ArrayList<>();

        combineHelper(1, n, k, currentResult, result);

        return result;
    }

    private void combineHelper(
            int startNumber, int n, int k,
            List<Integer> currentResult, List<List<Integer>> result) {

        if (currentResult.size() == k) {
            List<Integer> currentResultCopy = new ArrayList<>(currentResult);
            result.add(currentResultCopy);
            return;
        }

        for (int i = startNumber; i + k <= n + 1 + currentResult.size(); i++) {

            currentResult.add(i);

            combineHelper(i + 1,
                    n, k,
                    currentResult, result);

            currentResult.remove(currentResult.size() - 1);
        }
    }
}