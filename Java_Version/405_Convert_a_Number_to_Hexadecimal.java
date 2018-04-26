/*Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.

        Note:

        All letters in hexadecimal (a-f) must be in lowercase.
        The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
        The given number is guaranteed to fit within the range of a 32-bit signed integer.
        You must not use any method provided by the library which converts/formats the number to hex directly.
        Example 1:

        Input:
        26

        Output:
        "1a"
        Example 2:

        Input:
        -1

        Output:
        "ffffffff"*/


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

        int input = 26;

        String result = new Solution().toHex(input);

        return;
    }
}


class Solution {

    public String toHex(int num) {

        if (num == 0) {
            return "0";
        } else {
            return toHexHelper(num);
        }
    }

    private String toHexHelper(int num) {
        if (num == 0) {
            return "";
        } else {
            return toHexHelper(num >>> 4) + processHex(num & 15);
        }
    }

    private String processHex(int num) {

        if (num <= 9) {
            return String.valueOf((char)('0' + num));
        } else {
            return String.valueOf((char)('a' + num - 10));
        }
    }
}