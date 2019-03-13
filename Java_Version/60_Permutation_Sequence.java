/*
The set [1,2,3,...,n] contains a total of n! unique permutations. By listing
and labeling all of the permutations in order, we get the following sequence
for n = 3:

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
        Output: "2314"
*/

import java.util.LinkedList;
import java.util.List;

class Solution {

    public String getPermutation(int n, int k) {

        boolean[] hasUsed = new boolean[n];

        int[] totalNumbers = new int[n];
        totalNumbers[0] = 1;

        for (int i = 1; i < n; i++) {

            totalNumbers[i] = totalNumbers[i - 1] * i;
        }

        StringBuilder result = new StringBuilder();

        k--;

        for (int i = n; i >= 1; i--) {

            int currentIndex = k / totalNumbers[i - 1];

            int count = 0;
            for (int j = 0; ; j++) {
                if (count == currentIndex) {
                    if (!hasUsed[j]) {
                        hasUsed[j] = true;
                        result.append(j+1);
                        break;
                    }
                } else {
                    if (!hasUsed[j]) {
                        count++;
                    }
                }
            }

            k %= totalNumbers[i - 1];

        }

        return result.toString();
    }
}