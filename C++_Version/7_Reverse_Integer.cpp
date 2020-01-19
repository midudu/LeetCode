/*
  Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

  Input: 123
  Output: 321

Example 2:

  Input: -123
  Output: -321

Example 3:

  Input: 120
  Output: 21

Note:
  Assume we are dealing with an environment which could only store integers
within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of
this problem, assume that your function returns 0 when the reversed integer
overflows.
*/

#include <cstdint>

#include <iostream>

class Solution {
public:
    int reverse(int x) {
        if (x == INT32_MIN) {
            return 0;
        }
        bool isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        int result = 0;
        while (x != 0) {
            if (result > INT32_MAX / 10) {
                return 0;
            }

            result = result * 10 + (x % 10);
            x /= 10;
        }

        return isNegative ? -result : result;
    }
};


int main() {

    Solution solution = Solution();

    int result = solution.reverse(1534236469);

    std::cout << result << "\n";

    return 0;
}
