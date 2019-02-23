/*
Given two non-negative integers num1 and num2 represented as strings,
return the product of num1 and num2, also represented as a string.

Example 1:

        Input: num1 = "2", num2 = "3"
        Output: "6"

Example 2:

        Input: num1 = "123", num2 = "456"
        Output: "56088"

Note:

  The length of both num1 and num2 is < 110.

  Both num1 and num2 contain only digits 0-9.

  Both num1 and num2 do not contain any leading zero, except the number 0 itself.

  You must not use any built-in BigInteger library or convert the inputs to
integer directly.
*/

class Solution {

    public String multiply(String num1, String num2) {

        int len1 = num1.length(), len2 = num2.length();

        // There are at most (len1 + len2) bits for the multiply result
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {

                int carryBitPosition = i + j;
                int currentPosition = i + j + 1;

                int multiplicationResult =
                        (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int totalResult =
                        multiplicationResult + result[currentPosition];

                result[carryBitPosition] += totalResult / 10;
                result[currentPosition] = totalResult % 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int currentBitNum : result) {

            if (currentBitNum == 0 && stringBuilder.length() == 0) {
                continue;
            }

            stringBuilder.append(currentBitNum);
        }

        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}