/*
  Additive number is a string whose digits can form additive sequence.

  A valid additive sequence should contain at least three numbers. Except for
the first two numbers, each subsequent number in the sequence must be the sum
of the preceding two.

  Given a string containing only digits '0'-'9', write a function to determine
if it's an additive number.

Note:
  Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2,
03 or 1, 02, 3 is invalid.

Example 1:

        Input: "112358"
        Output: true
        Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
        1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8

Example 2:

        Input: "199100199"
        Output: true
        Explanation: The additive sequence is: 1, 99, 100, 199.
        1 + 99 = 100, 99 + 100 = 199

Follow up:
        How would you handle overflow for very large input integers?
*/

class Solution {

    public boolean isAdditiveNumber(String num) {

        if (num == null || num.length() < 3) {
            return false;
        }

        for (int i = 0; i < num.length(); i++) {

            String num1 = num.substring(0, i + 1);

            if (num1.isEmpty() ||
                    (num1.length() != 1 && num1.charAt(0) == '0')) {
                continue;
            }

            for (int j = i + 1; j < num.length(); j++) {

                String num2 = num.substring(i + 1, j + 1);
                if (num2.isEmpty() ||
                        (num2.length() != 1 && num2.charAt(0) == '0')) {
                    continue;
                }

                for (int k = j + 1; k < num.length(); k++) {

                    int num12Length = Math.max(num1.length(), num2.length());
                    int num3Length = k - j;
                    if (num3Length < num12Length || num3Length > num12Length + 1) {
                        continue;
                    }

                    String num3 = num.substring(j + 1, k + 1);
                    if (num3.isEmpty() ||
                            (num3.length() != 1 && num3.charAt(0) == '0')) {
                        continue;
                    }

                    String sum = addTwoNumbers(num1, num2);

                    if (!num3.equals(sum)) {
                        continue;
                    }

                    if (isAdditiveNumberHelper(num, k + 1, num2, num3)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private String addTwoNumbers(String num1, String num2) {

        StringBuilder result = new StringBuilder();

        int carryBit = 0;

        int num1Pointer = num1.length() - 1, num2Pointer = num2.length() - 1;

        while (num1Pointer >= 0 || num2Pointer >= 0) {

            int currentBit1 = (num1Pointer >= 0 ? num1.charAt(num1Pointer) - '0' : 0);
            int currentBit2 = (num2Pointer >= 0 ? num2.charAt(num2Pointer) - '0' : 0);

            int currentSum = currentBit1 + currentBit2 + carryBit;
            carryBit = (currentSum > 9 ? 1 : 0);
            currentSum = (currentSum > 9 ? currentSum - 10 : currentSum);

            result.append(currentSum);

            num1Pointer--;
            num2Pointer--;
        }

        return (carryBit == 0 ? result.reverse().toString() :
                "1" + result.reverse().toString());
    }

    private boolean isAdditiveNumberHelper(
            String num, int startIndex, String num1, String num2) {

        if (startIndex == num.length()) {
            return true;
        }

        String sum = addTwoNumbers(num1, num2);

        for (int i = startIndex; i < num.length(); i++) {

            int sumLength = sum.length();
            int num3Length = i - startIndex + 1;

            if (num3Length < sumLength || num3Length > sumLength + 1) {
                continue;
            }

            String num3 = num.substring(startIndex, i + 1);
            if (num3.isEmpty() ||
                    (num3.length() != 1 && num3.charAt(0) == '0')) {
                continue;
            }

            if (num3.equals(sum)) {

                if (isAdditiveNumberHelper(num, i + 1, num2, num3)) {
                    return true;
                }
            }
        }

        return false;
    }
}