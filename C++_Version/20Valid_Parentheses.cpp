/*
  Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true

Example 2:

Input: "()[]{}"
Output: true

Example 3:

Input: "(]"
Output: false

Example 4:

Input: "([)]"
Output: false

Example 5:

Input: "{[]}"
Output: true
*/

#include <string>
#include <cassert>

using namespace std;

class Solution {
public:
    Solution() {
        map['('] = ')';
        map[')'] = '(';
        map['['] = ']';
        map[']'] = '[';
        map['{'] = '}';
        map['}'] = '{';
    }

    bool isValid(string s) {
        if (s.empty()) {
            return true;
        }

        char stack[s.size()];
        int pointer = 0;

        for (string::size_type i = 0; i < s.size(); i++) {
            char ch = s[i];
            assert(map[ch] != 0);

            if (pointer == 0 || !isMatchParentheses(ch, stack[pointer - 1])) {
                stack[pointer] = ch;
                pointer++;
            } else {
                pointer--;
            }
        }

        return pointer == 0;
    }

private:
    char map[256] = {0};

    bool isMatchParentheses(char ch1, char ch2) {
        return map[ch1] == ch2;
    }
};

int main(int argc, char *args[]) {
    string inputs[] = {"()", "()[]{}", "(]", "([)]", "{[]}"};

    bool result[sizeof(inputs) / sizeof(string)];

    Solution solution;

    for (int i = 0; i < sizeof(inputs) / sizeof(string); i++) {
        result[i] = solution.isValid(inputs[i]);
    }

    return 0;
}

