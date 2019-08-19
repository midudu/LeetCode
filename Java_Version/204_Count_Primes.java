/*
  Description:
    Count the number of prime numbers less than a non-negative number, n.
*/

class Solution {

    public int countPrimes(int n) {

        if (n < 0) {
            throw new RuntimeException("illegal input");
        }
        if (n == 0 || n == 1) {
            return 0;
        }

        int result = 0;
        boolean[] isNotPrime = new boolean[n];

        for (int i = 2; i < n; i++) {

            if (isNotPrime[i]) {
                continue;
            }

            result++;

            for (int j = i + i; j < n; j += i) {
                isNotPrime[j] = true;
            }
        }

        return result;
    }
}
