/*
  Write a function that takes a string as input and reverse only the vowels of
a string.

Example 1:

        Given s = "hello", return "holle".

Example 2:

        Given s = "leetcode", return "leotcede".

Note:
  The vowels does not include the letter "y".
*/

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().reverseVowels("lEetcode"));
    }

    public String reverseVowels(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int startPointer = 0, endPointer = chars.length - 1;

        while (startPointer < endPointer) {

            while (startPointer < endPointer && !isVowelChar(chars[startPointer])) {
                startPointer++;
            }
            while (startPointer < endPointer && !isVowelChar(chars[endPointer])) {
                endPointer--;
            }

            if (startPointer < endPointer) {
                swap(chars, startPointer, endPointer);
                startPointer++;
                endPointer--;
            }
        }

        return new String(chars);
    }

    private boolean isVowelChar(char c) {

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] chars, int index1, int index2) {

        char temp = chars[index1];

        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}
