/*Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

        Note:

        The length of both num1 and num2 is < 5100.
        Both num1 and num2 contains only digits 0-9.
        Both num1 and num2 does not contain any leading zero.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.*/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test {
    public static void main(String[] args) {

        System.out.println((int) ('A'));
        System.out.println((int) ('a'));
    }
}


class Solution {
    public String addStrings(String num1, String num2) {

        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }

        int num1Pointer = num1.length() - 1;
        int num2Pointer = num2.length() - 1;
        int carryBit = 0;
        StringBuilder stringBuilder = new StringBuilder(num1);

        while (num2Pointer >= 0) {

            int num1CurrentDegit = num1.charAt(num1Pointer) - '0';
            int num2CurrentDegit = num2.charAt(num2Pointer) - '0';

            int currentSum = num1CurrentDegit + num2CurrentDegit + carryBit;
            if (currentSum >= 10) {
                carryBit = 1;
                stringBuilder.setCharAt(num1Pointer, (char) (currentSum - 10 + '0'));
            } else {
                carryBit = 0;
                stringBuilder.setCharAt(num1Pointer, (char) (currentSum + '0'));
            }

            num1Pointer--;
            num2Pointer--;
        }

        while (num1Pointer>=0 && carryBit == 1) {
            int num1CurrentDegit = num1.charAt(num1Pointer) - '0';

            int currentSum = num1CurrentDegit + carryBit;
            if (currentSum == 10) {
                carryBit = 1;
                stringBuilder.setCharAt(num1Pointer, '0');
            } else {
                carryBit = 0;
                stringBuilder.setCharAt(num1Pointer, (char) (currentSum + '0'));
            }

            num1Pointer--;
        }

        if (carryBit == 1) {
            return "1" + stringBuilder.toString();
        } else {
            return stringBuilder.toString();
        }
    }
}