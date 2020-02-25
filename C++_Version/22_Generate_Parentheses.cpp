/*
  Given n pairs of parentheses, write a function to generate all combinations
of well-formed parentheses.

For example, given n = 3, a solution set is:

[
"((()))",
"(()())",
"(())()",
"()(())",
"()()()"
]
*/

#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> result;

        if (n < 1) {
            return result;
        }

        generateParenthesis("", n, n, result);
        return result;
    }

private:
    void generateParenthesis(
            string existingResult, int left, int right,
            vector<string> &result) {
        if (left == 0) {
            result.push_back(existingResult + getRightParenthesis(right));
            return;
        }

        if (left >= right) {
            generateParenthesis(existingResult + '(', left - 1, right, result);
        } else {
            generateParenthesis(existingResult + '(', left - 1, right, result);
            generateParenthesis(existingResult + ')', left, right - 1, result);
        }
    }

    string getRightParenthesis(int n) {
        if (n == 0) {
            return "";
        }

        string result;
        result.reserve(n);
        for (int i = 0; i < n; i++) {
            result += ')';
        }

        return result;
    }
};

int main(int argc, char **args) {

    Solution solution;

    vector<string> result = solution.generateParenthesis(3);

    return 0;
}
