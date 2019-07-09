/*
  Initially on a notepad only one character 'A' is present. You can perform two
operations on this notepad for each step:

  Copy All: You can copy all the characters present on the notepad (partial
copy is not allowed).

  Paste: You can paste the characters which are copied last time.

  Given a number n. You have to get exactly n 'A' on the notepad by performing
the minimum number of steps permitted. Output the minimum number of steps to
get n 'A'.

Example 1:

        Input: 3
        Output: 3

        Explanation:

        Intitally, we have one character 'A'.

        In step 1, we use Copy All operation.
        In step 2, we use Paste operation to get 'AA'.
        In step 3, we use Paste operation to get 'AAA'.


Note:

  The n will be in the range [1, 1000].
*/

class Solution {

    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
            System.out.println(new Solution().minSteps(i));
        }
    }

    public int minSteps(int n) {

        if (n < 1) {
            throw new RuntimeException("illegal input");
        } else if (n == 1) {
            return 0;
        }

        return minStepsHelper(n);
    }

    private int minStepsHelper(int n) {

        for (int i = n - 1; i > 1; i--) {

            if (n % i == 0) {
                return minSteps(i) + (n / i);
            }
        }

        return n;
    }
}
