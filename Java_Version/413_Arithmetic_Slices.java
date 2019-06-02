/*
  A sequence of number is called arithmetic if it consists of at least three
elements and if the difference between any two consecutive elements is the same.

  For example, these are arithmetic sequence:

        1, 3, 5, 7, 9
        7, 7, 7, 7
        3, -1, -5, -9

  The following sequence is not arithmetic.

        1, 1, 2, 5, 7

  A zero-indexed array A consisting of N numbers is given. A slice of that
array is any pair of integers (P, Q) such that 0 <= P < Q < N.

  A slice (P, Q) of array A is called arithmetic if the sequence:
        A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic.
  In particular, this means that P + 1 < Q.

  The function should return the number of arithmetic slices in the array A.

Example:

        A = [1, 2, 3, 4]

        return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*/

class Solution {

    public int numberOfArithmeticSlices(int[] A) {

        if (A == null || A.length < 3) {
            return 0;
        }

        int[] diff = new int[A.length - 1];

        for (int i = 0; i < diff.length; i++) {
            diff[i] = A[i + 1] - A[i];
        }

        int result = 0;

        int startIndex = 0;

        for (int i = 1; i < diff.length; i++) {

            if (diff[i] != diff[startIndex]) {

                int n = i - startIndex;

                result += (n-1)*n/2;

                startIndex = i;
            }
        }

        int n = diff.length - startIndex;

        return result + n * (n-1)/2;
    }
}