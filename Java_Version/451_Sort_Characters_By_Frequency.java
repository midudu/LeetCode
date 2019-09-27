/*
  Given a string, sort it in decreasing order based on the frequency of
characters.

Example 1:

        Input:
        "tree"

        Output:
        "eert"

        Explanation:
        'e' appears twice while 'r' and 't' both appear once.
        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a
        valid answer.

Example 2:

        Input:
        "cccaaa"

        Output:
        "cccaaa"

        Explanation:
        Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
        Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

        Input:
        "Aabb"

        Output:
        "bbAa"

        Explanation:
        "bbaA" is also a valid answer, but "Aabb" is incorrect.

        Note that 'A' and 'a' are treated as two different characters.
*/

import java.util.*;

class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().frequencySort("loveleetcode"));
    }

    public String frequencySort(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] sChar = s.toCharArray();

        HashMap<Character, Integer> charCount = new HashMap<>(sChar.length);
        for (char ch : sChar) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        TreeMap<Integer, List<Character>> countChars = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            Character ch = entry.getKey();
            Integer count = entry.getValue();

            List<Character> characterList = countChars.getOrDefault(count, new ArrayList<>());
            characterList.add(ch);
            countChars.put(count, characterList);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, List<Character>> entry : countChars.entrySet()) {
            int count = entry.getKey();
            List<Character> list = entry.getValue();
            for (Character ch : list) {
                for (int i = 0; i < count; i++) {
                    result.append(ch);
                }
            }
        }

        return result.reverse().toString();
    }
}
