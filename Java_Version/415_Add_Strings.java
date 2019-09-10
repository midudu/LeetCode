/*
  Given two non-negative integers num1 and num2 represented as string, return
the sum of num1 and num2.

Note:
  1. The length of both num1 and num2 is < 5100.
  2. Both num1 and num2 contains only digits 0-9.
  3. Both num1 and num2 does not contain any leading zero.
  4. You must not use any built-in BigInteger library or convert the inputs to
integer directly.
*/

class Solution {

    public String addStrings(String num1, String num2) {

        if (num1 == null || num2 == null
                || num1.length() == 0 || num2.length() == 0) {
            throw new RuntimeException("illegal input");
        }

        char[] result = new char[Math.max(num1.length(), num2.length()) + 1];
        int carry = 0;

        for (int i = num1.length() - 1, j = num2.length() - 1, k = result.length - 1;
                i >= 0 || j >= 0; i--, j--, k--) {

            int bit1 = (i >= 0 ? num1.charAt(i) - '0' : 0);
            int bit2 = (j >= 0 ? num2.charAt(j) - '0' : 0);

            int sum = bit1 + bit2 + carry;
            if (sum >= 10) {
                carry = 1;
                sum -= 10;
            } else {
                carry = 0;
            }

            result[k] = (char)(sum + '0');
        }

        if (carry == 1) {
            result[0] = '1';
            return new String(result);
        } else {
            return new String(result).substring(1);
        }
    }
}
