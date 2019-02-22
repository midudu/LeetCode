/*
  Given n pairs of parentheses,
  write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
        ]
*/

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {

        if (n <= 0) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();

        generateParenthesisHelper(result, "",
                0, 0, n);

        return result;
    }

    private void generateParenthesisHelper(
            List<String> result, String existingString,
            int existingLeftNumbers, int existingRightNumbers, int n) {

        if (existingLeftNumbers == n && existingRightNumbers == n) {
            result.add(existingString);
            return;
        }

        if (existingLeftNumbers < n) {
            generateParenthesisHelper(result, existingString + "(",
                    existingLeftNumbers + 1,
                    existingRightNumbers, n);
        }

        if (existingRightNumbers < n && existingRightNumbers < existingLeftNumbers) {
            generateParenthesisHelper(result, existingString + ")",
                    existingLeftNumbers,
                    existingRightNumbers + 1, n);
        }
    }
}