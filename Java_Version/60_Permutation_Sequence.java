/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

        By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        Given n and k, return the kth permutation sequence.

        Note:

        Given n will be between 1 and 9 inclusive.
        Given k will be between 1 and n! inclusive.
        Example 1:

        Input: n = 3, k = 3
        Output: "213"
        Example 2:

        Input: n = 4, k = 9
        Output: "2314"*/

import java.util.LinkedList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {

        List<Integer> nums = new LinkedList<>();
        int[] fact = new int[n];
        fact[0] = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            nums.add(i + 1);
            if (i != 0)
                fact[i] = fact[i - 1] * i;
        }

        k--;

        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            sb.append(nums.get(index));
            k %= fact[i - 1];
            nums.remove(index);

        }

        return sb.toString();
    }
}