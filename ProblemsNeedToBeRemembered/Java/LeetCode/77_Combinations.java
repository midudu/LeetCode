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

        List<List<Integer>> result = new Solution().combine(4,2);
        System.out.println(result.toString());
    }

    public List<List<Integer>> combine(int n, int k) {

        if (n < 1 || k < 0 || k > n) {
            throw new RuntimeException("illegal input");
        }

        List<List<Integer>> result = new ArrayList<>();

        combineHelper(result, new ArrayList<>(), 1, n, k);

        return result;
    }

    private void combineHelper(
            List<List<Integer>> result, List<Integer> existingNums,
            int startNum, int n, int k) {

        if (existingNums.size() == k) {
            result.add(new ArrayList<>(existingNums));
            return;
        }

        int endNum = n - k + 1 + existingNums.size();
        for (int i = startNum; i <= endNum; i++) {

            existingNums.add(i);
            combineHelper(result, existingNums, i + 1, n, k);
            existingNums.remove(existingNums.size() - 1);
        }
    }
}