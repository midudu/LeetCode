/*Given a non-negative integer represented as a non-empty array of digits, plus
one to the integer.

You may assume the integer do not contain any leading zero, except the number 0
itself.

The digits are stored such that the most significant digit is at the head of
the list.
*/


class Solution {
    public int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return digits;
        }

        int carryBit = 1;
        int currentIndex = digits.length - 1;

        do {

            int currentSum = carryBit + digits[currentIndex];
            carryBit = (currentSum > 9 ? 1 : 0);
            digits[currentIndex]
                    = (currentSum > 9 ? currentSum - 10 : currentSum);

            currentIndex--;

        } while (carryBit != 0 && currentIndex >= 0);

        if (carryBit == 0) {
            return digits;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }
}