/*
  Given a string and a string dictionary, find the longest string in the
dictionary that can be formed by deleting some characters of the given string.
If there are more than one possible results, return the longest word with the
smallest lexicographical order. If there is no possible result, return the
empty string.

Example 1:

        Input:
        s = "abpcplea", d = ["ale","apple","monkey","plea"]

        Output:
        "apple"

Example 2:

        Input:
        s = "abpcplea", d = ["a","b","c"]

        Output:
        "a"

Note:
  1. All the strings in the input will only contain lower-case letters.
  2. The size of the dictionary won't exceed 1,000.
  3. The length of all the strings in the input won't exceed 1,000.
*/

import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        String s = "abpcplea";
        List<String> d = Arrays.asList("c", "b", "a");

        System.out.println(new Solution().findLongestWord(s, d));
    }

    public String findLongestWord(String s, List<String> d) {

        if (d == null || d.size() == 0 || s == null || s.length() == 0) {
            return "";
        }

        String result = "";

        for (String word : d) {

            if (word.length() > s.length()) {
                continue;
            }

            if (canFormStringByDeletion(s, word)) {
                if (result.equals("")) {
                    result = word;
                }  else {
                    if (word.length() > result.length() ||
                            word.length() == result.length() && word.compareTo(result) < 0) {
                        result = word;
                    }
                }
            }
        }

        return result;
    }

    private boolean canFormStringByDeletion(String longer, String shorter) {

        int pointerLonger = 0, pointerShorter = 0;

        while (pointerLonger < longer.length()) {

            while (pointerLonger < longer.length()
                    && shorter.charAt(pointerShorter) != longer.charAt(pointerLonger)) {
                pointerLonger++;
            }
            if (pointerLonger != longer.length()) {
                pointerShorter++;
                pointerLonger++;
                if (pointerShorter == shorter.length()) {
                    break;
                }
            }
        }

        return pointerShorter == shorter.length();
    }
}
