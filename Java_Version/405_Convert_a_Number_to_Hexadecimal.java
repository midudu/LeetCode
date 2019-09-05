/*
  Given an integer, write an algorithm to convert it to hexadecimal. For
negative integer, two’s complement method is used.

Note:
  1. All letters in hexadecimal (a-f) must be in lowercase.
  2. The hexadecimal string must not contain extra leading 0s. If the number is
  zero, it is represented by a single zero character '0'; otherwise, the first
  character in the hexadecimal string will not be the zero character.
  3. The given number is guaranteed to fit within the range of a 32-bit signed
  integer.
  4. You must not use any method provided by the library which converts/formats
  the number to hex directly.

Example 1:

        Input:
        26

        Output:
        "1a"

Example 2:

        Input:
        -1

        Output:
        "ffffffff"
*/

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().toHex(-1));
    }

    public String toHex(int num) {

        if (num == 0) {
            return "0";
        }

        char[] map = new char[16];
        for (int i = 0; i < 10; i++) {
            map[i] = (char) ('0' + i);
        }
        for (int i = 10; i < 16; i++) {
            map[i] = (char) ('a' + i - 10);
        }

        StringBuilder result = new StringBuilder();

        while (num != 0) {
            int currentHex = (num & 15);
            result.append(map[currentHex]);

            num >>>= 4;
        }

        return result.reverse().toString();
    }
}
