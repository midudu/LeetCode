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

class Solution {

    public String getPermutation(int n, int k) {

        if (n < 1 || n > 9) {
            return null;
        }

        int[] factorialNumbers = new int[n];
        factorialNumbers[0] = 1;
        for (int i = 2; i <= n; i++) {
            factorialNumbers[i - 1] = factorialNumbers[i - 2] * i;
        }

        String[] numbersString = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        return getPermutationHelper(n, k, factorialNumbers, numbersString);
    }

    private String getPermutationHelper(
            int n, int k, int[] factorialNumbers, String[] numbersString) {

        
    }
}