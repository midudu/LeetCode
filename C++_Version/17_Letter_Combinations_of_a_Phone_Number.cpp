/*
  Given a string containing digits from 2-9 inclusive, return all possible
letter combinations that the number could represent.

  A mapping of digit to letters (just like on the telephone buttons) is given
below. Note that 1 does not map to any letters.

Example:

  Input: "23"
  Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

Note:
  Although the above answer is in lexicographical order, your answer could be
in any order you want.
*/

#include <vector>
#include <string>
#include <cassert>

using namespace std;

class Solution {
public:
    Solution() {
        map['2'] = "abc";
        map['3'] = "def";
        map['4'] = "ghi";
        map['5'] = "jkl";
        map['6'] = "mno";
        map['7'] = "pqrs";
        map['8'] = "tuv";
        map['9'] = "wxyz";
    }

    vector<string> letterCombinations(string digits) {
        vector<string> result;
        if (digits.empty()) {
            return result;
        }

        // TODO: reserve size

        letterCombinationsHelper("", digits, 0, result);
        return result;
    }

    void letterCombinationsHelper(
            const string &prefix, const string &digits, const int currentIndex,
            vector<string> &result) {

        if (currentIndex == (int) digits.size()) {
            result.push_back(prefix);
            return;
        }

        char currentChar = digits[currentIndex];
        assert(currentChar >= '2' && currentChar <= '9');

        for (const char &ch : map[currentChar]) {
            letterCombinationsHelper(prefix + ch, digits,
                    currentIndex + 1, result);
        }
    }

private:
    string map[256];
};

int main() {

    Solution solution;
    vector<string> result = solution.letterCombinations("23");

    return 0;
}
