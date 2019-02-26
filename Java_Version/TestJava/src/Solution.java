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
import java.util.Map;


class Solution {

    public int lengthOfLongestSubstring(String s) {

        if ( s == null || s.length() == 0 ) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        int result = 0;
        int startIndex = 0;

        for ( int i = 0; i < s.length(); i++ ) {

            if ( map.(s.charAt(i))) {
                startIndex = Math.max(startIndex, map.get(s.charAt(i)) + 1);
            }

            result = Math.max(result, i - startIndex + 1);
            map.put(s.charAt(i), i);
        }

        return result;
    }
}