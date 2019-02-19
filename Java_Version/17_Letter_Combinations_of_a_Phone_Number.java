/*
Given a string containing digits from 2-9 inclusive,
return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.


Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:

Although the above answer is in lexicographical order,
your answer could be in any order you want.*/

import java.util.*;

class Solution {

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        String[] map = {" ", "*", "abc", "def", "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"};

        letterCombinationsHelper(digits, 0, "", map);

        return this.result;
    }

    private void letterCombinationsHelper(
            String digits, int currentIndex,
            String existingString, String[] map) {

        if (currentIndex == digits.length()) {

            this.result.add(existingString);

            return;
        }

        String possibleValues = map[digits.charAt(currentIndex) - '0'];
        for (int i = 0; i < possibleValues.length(); i++) {
            letterCombinationsHelper(digits, currentIndex + 1,
                    existingString + possibleValues.charAt(i), map);
        }
    }
}

