/*
  Determine whether an integer is a palindrome. An integer is a palindrome when
it reads the same backward as forward.

Example 1:

  Input: 121
  Output: true

Example 2:

  Input: -121
  Output: false

  Explanation: From left to right, it reads -121. From right to left, it
  becomes 121-. Therefore it is not a palindrome.

Example 3:

  Input: 10
  Output: false

  Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:

  Coud you solve it without converting the integer to a string?
*/

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reverseX = 0;

        while (x > reverseX) {
            reverseX = reverseX * 10 + (x % 10);
            x /= 10;
        }

        return x == reverseX || x == reverseX / 10;
    }
};


#include <iostream>

int main(int argc, char **args) {

    Solution solution;

    std::cout << solution.isPalindrome(121) << "\n"
              << solution.isPalindrome(-121) << "\n"
              << solution.isPalindrome(10) << "\n"
              << solution.isPalindrome(1221);
}
