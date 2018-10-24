import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        String[] key = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        helper(res, "", 0, digits, key);

        return res;

    }

    public void helper(
            List<String> res, String curr, int currIdx, String digits, String[] key) {

        if (currIdx > digits.length() - 1) {
            res.add(curr);
            return;
        }

        String digit = key[(digits.charAt(currIdx) - '0')];

        for (int i = 0; i < digit.length(); i++) {

            helper(res, curr + digit.charAt(i),
                    currIdx + 1, digits, key);
        }
    }
}