/*
  Find all possible combinations of k numbers that add up to a number n, given
that only numbers from 1 to 9 can be used and each combination should be a
unique set of numbers.

Note:
  1. All numbers will be positive integers.
  2. The solution set must not contain duplicate combinations.

Example 1:

        Input: k = 3, n = 7
        Output: [[1,2,4]]

Example 2:

        Input: k = 3, n = 9
        Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        List<List<Integer>> result = new Solution().combinationSum3(3, 9);

        System.out.println();
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> result = new ArrayList<>();

        if (k <= 0 || n <= 0) {
            return result;
        }

        combinationSum3Helper(result, new ArrayList<>(), 1, n, k);

        return result;
    }

    private void combinationSum3Helper(List<List<Integer>> result,
                                       ArrayList<Integer> existingNumbers, int startNumber, int target, int leftNumbersCount) {

        if (leftNumbersCount == 0) {
            if (target == 0) {
                result.add(new ArrayList<>(existingNumbers));
            }
            return;
        }

        for (int i = startNumber; i <= Math.min(9, target); i++) {

            existingNumbers.add(i);
            combinationSum3Helper(result, existingNumbers, i + 1,
                    target - i, leftNumbersCount - 1);
            existingNumbers.remove(existingNumbers.size() - 1);
        }

    }
}
