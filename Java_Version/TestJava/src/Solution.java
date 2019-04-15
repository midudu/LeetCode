/*
  A message containing letters from A-Z is being encoded to numbers using the
following mapping:

        'A' -> 1
        'B' -> 2
        ...
        'Z' -> 26

  Given a non-empty string containing only digits, determine the total number
of ways to decode it.0

Example 1:

        Input: "12"
        Output: 2
        Explanation: It could be decoded as "AB" (1 2) or "L" (12).

Example 2:

        Input: "226"
        Output: 3
        Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF"
(2 2 6).
*/


public class Solution {

    public static void main(String[] args) {

        new Solution().numDecodings("10");
    }

    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int result1 = 1, result2 = (s.charAt(0) != '0' ? 1 : 0);

        for (int i = 1; i < s.length(); i++) {

            int currentResult = 0;

            if (s.charAt(i) != '0') {
                currentResult += result2;
            }

            if ((s.charAt(i - 1) == '1' && s.charAt(i) >= '0' && s.charAt(i) <= '9')
                ||
            (s.charAt(i - 1) == '2' && s.charAt(i) >= '0' && s.charAt(i) <= '6')) {
                currentResult += result1;
            }

            result1 = result2;
            result2 = currentResult;
        }

        return result2;
    }
}