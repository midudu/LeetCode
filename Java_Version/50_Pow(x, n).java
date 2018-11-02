/*
Implement pow(x, n), which calculates x raised to the power n (xn).

        Example 1:

        Input: 2.00000, 10
        Output: 1024.00000
        Example 2:

        Input: 2.10000, 3
        Output: 9.26100
        Example 3:

        Input: 2.00000, -2
        Output: 0.25000
        Explanation: 2-2 = 1/22 = 1/4 = 0.25
        Note:

        -100.0 < x < 100.0
        n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]*/

import java.util.HashMap;

class Solution {

    private HashMap<Integer, Double> resultSet = new HashMap<>();

    public double myPow(double x, int n) {

        resultSet.put(0, 1.0);
        resultSet.put(1, x);
        resultSet.put(-1, 1.0 / x);

        return myPowHelper(x, n);
    }


    private double myPowHelper(double x, int n) {

        if (resultSet.containsKey(n)) {
            return resultSet.get(n);
        }

        int n1 = n / 2;
        int n2 = n - n1;

        double result1 = myPowHelper(x, n1);
        double result2 = myPowHelper(x, n2);

        double result = result1 * result2;

        resultSet.put(n1, result1);
        resultSet.put(n2, result2);
        resultSet.put(n, result);

        return result;
    }
}
