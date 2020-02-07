/*
  Implement atoi which converts a string to an integer.

  The function first discards as many whitespace characters as necessary until
the first non-whitespace character is found. Then, starting from this character,
takes an optional initial plus or minus sign followed by as many numerical
digits as possible, and interprets them as a numerical value.

  The string can contain additional characters after those that form the
integral number, which are ignored and have no effect on the behavior of this
function.

  If the first sequence of non-whitespace characters in str is not a valid
integral number, or if no such sequence exists because either str is empty or
it contains only whitespace characters, no conversion is performed.

  If no valid conversion could be performed, a zero value is returned.

Note:

  1. Only the space character ' ' is considered as whitespace character.

  2. Assume we are dealing with an environment which could only store integers
  within the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical
  value is out of the range of representable values, INT_MAX (2^31 − 1) or
  INT_MIN (−2^31) is returned.

Example 1:

  Input: "42"
  Output: 42

Example 2:

  Input: "   -42"
  Output: -42

  Explanation: The first non-whitespace character is '-', which is the minus
  sign. Then take as many numerical digits as possible, which gets 42.

Example 3:

  Input: "4193 with words"
  Output: 4193

  Explanation: Conversion stops at digit '3' as the next character is not a
  numerical digit.

Example 4:

  Input: "words and 987"
  Output: 0

  Explanation: The first non-whitespace character is 'w', which is not a
  numerical digit or a +/- sign. Therefore no valid conversion could be
  performed.

Example 5:

  Input: "-91283472332"
  Output: -2147483648

  Explanation: The number "-91283472332" is out of the range of a 32-bit signed
  integer. Therefore INT_MIN (−2^31) is returned.
*/

#include <string>
#include <iostream>

using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        if (str.empty()) {
            return 0;
        }
        long result = 0;
        bool isNegative = false;

        // 1. Deal with the forward whitespace
        string::size_type i;
        for (i = 0; i < str.length(); i++) {
            if (str[i] != ' ') {
                break;
            }
        }

        // 2. Deal with the sign bit
        if (str[i] == '+' || str[i] == '-') {
            isNegative = (str[i] == '-');
            i++;
        }

        // 3. Deal with the main part
        for (; i < str.length(); i++) {
            if (str[i] < '0' || str[i] > '9') {
                break;
            }
            result = result * 10 + (str[i] - '0');
            if (result > INT32_MAX || result < INT32_MIN) {
                break;
            }
        }

        if (isNegative) {
            result = -result;
        }
        return (result > INT32_MAX ? INT32_MAX :
                (result < INT32_MIN ? INT32_MIN : result));
    }
};


int main(int argc, char **args) {

    Solution solution = Solution();

    string inputs[] = {"42", "   -42", "4193 with words", "words and 987", "-91283472332"};
    int outputs[5];

    for (int i = 0; i < sizeof(inputs) / sizeof(inputs[0]); i++) {
        outputs[i] = solution.myAtoi(inputs[4]);
    }

    return 0;
}