/*Given a string, find the length of the longest substring without repeating
characters.

Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3.

Note that the answer must be a substring, "pwke" is a subsequence and not a
substring.
*/

import java.lang.Math;
import java.util.HashMap;


class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> lastExistingCharIndex = new HashMap<>();

        int result = 0;
        int startIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            if (lastExistingCharIndex.containsKey(s.charAt(i))) {

                // In case of situation like "abba"
                startIndex = Math.max(lastExistingCharIndex.get(s.charAt(i)) + 1,
                        startIndex);
            }

            lastExistingCharIndex.put(s.charAt(i), i);

            result = Math.max(result, i - startIndex + 1);
        }

        return result;
    }
}