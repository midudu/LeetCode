/*
  Given two binary strings, return their sum (also a binary string).

        For example,
        a = "11"
        b = "1"
        Return "100".
*/

class Solution {

    public String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();

        int carryBit = 0;
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;

        while (aPointer >= 0 || bPointer >= 0) {

            int aBit = (aPointer >= 0 ? a.charAt(aPointer) - '0' : 0);
            int bBit = (bPointer >= 0 ? b.charAt(bPointer) - '0' : 0);

            int currentSum = carryBit + aBit + bBit;

            carryBit = (currentSum > 1 ? 1 : 0);

            if (currentSum > 1) {
                currentSum -= 2;
            }

            result.append(currentSum);

            aPointer--;
            bPointer--;
        }

        if (carryBit != 0) {
            result.append(1);     //先append()再reverse的效率高于insert()
        }

        return result.reverse().toString();
    }
}