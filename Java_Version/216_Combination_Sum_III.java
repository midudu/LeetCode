/*
Find all possible combinations of k numbers that add up to a number n,

given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

        Note:

        All numbers will be positive integers.
        The solution set must not contain duplicate combinations.
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

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {

        if (k <= 0 || n <= 0) {
            return result;
        }

        int[] map = new int[9];
        for (int i = 0; i < map.length; i++) {
            map[i] = 9 - i;
        }

        ArrayList<Integer> existingNumbers = new ArrayList<>();

        combinationSum3Helper(existingNumbers, k, n, map, 0);

        return result;
    }

    private void combinationSum3Helper(
            ArrayList<Integer> existingNumbers, int k, int n,
            int[] map, int startIndex) {

        if (n <= 0 || startIndex >= map.length) {
            return;
        }

        if (k == 1) {
            if (map[startIndex] >= n) {

                ArrayList<Integer> newResult = new ArrayList<>(existingNumbers);
                newResult.add(n);

                this.result.add(newResult);
            }
            return;
        }


        for (int i = startIndex; i < map.length; i++) {

            existingNumbers.add(map[i]);

            combinationSum3Helper(existingNumbers, k - 1, n - map[i],
                    map, i + 1);

            existingNumbers.remove(existingNumbers.size() - 1);
        }
    }
}