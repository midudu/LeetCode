/*
Given two integers representing the numerator and denominator of a fraction,

return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

        Input: numerator = 1, denominator = 2
        Output: "0.5"

        Example 2:

        Input: numerator = 2, denominator = 1
        Output: "2"

        Example 3:

        Input: numerator = 2, denominator = 3
        Output: "0.(6)"*/

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String fractionToDecimal(int numerator, int denominator) {

        // Step 1: Judge if {@code numerator} is zero
        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Step 2: Judge if the result is positive
        if ((numerator < 0 && denominator > 0)
                || (numerator > 0 && denominator < 0)) {
            result.append('-');
        }

        // Step 3: Convert {@code numerator} and {@code denominator} to
        // positive long numbers in case of {@code denominator} is very huge
        // but {@code numerator} is tiny small
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);

        // Step 4: Do the first division operation
        long divideResult = num / denom;
        long remainder = num % denom;

        result.append(divideResult);
        if (remainder == 0) {
            return result.toString();
        } else {
            result.append('.');
        }

        // Step 5: Deal with the fraction part
        Map<Long, Integer> map = new HashMap<>();

        // once the remainder starts repeating, so does the divided result.
        while (!map.containsKey(remainder)) {

            map.put(remainder, result.length());

            divideResult = remainder * 10 / denom;
            remainder = remainder * 10 % denom;

            if (remainder != 0 || (remainder == 0 && !map.containsKey(remainder))) {
                result.append(divideResult);
            }
        }

        // Step 6: Add () to loop situation if necessary
        if (remainder != 0) {
            result.insert(map.get(remainder), "(");
            result.append(')');
        }

        return result.toString();
    }
}