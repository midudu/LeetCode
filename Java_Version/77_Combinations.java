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

        List<List<Integer>> answer = new ArrayList<>();

        combine(answer, new ArrayList<>(), 1, n, k);

        return answer;
    }

    private void combine(List<List<Integer>> answer,
                         List<Integer> arr, int startNum, int n, int k) {

        if (arr.size() == k) {

            answer.add(new ArrayList<>(arr));

        } else {

            int index = arr.size();
            int endNum = n - k + index + 1;

            for (int i = startNum; i <= endNum; i++) {

                arr.add(i);
                combine(answer, arr, i + 1, n, k);
                arr.remove(index);
            }
        }
    }
}