/*
  Given a string s, find the longest palindromic substring in s. You may assume
that the maximum length of s is 1000.

Example 1:

  Input: "babad"
  Output: "bab"

  Note: "aba" is also a valid answer.

Example 2:

  Input: "cbbd"
  Output: "bb"
*/

#include <string>
#include <iostream>

using namespace std;

class Solution {
public:
    Solution() : resultLength(0), startIndex(-1) {}

    string longestPalindrome(string s) {

        if (s.length() == 0) {
            return "";
        }

        for (string::size_type i = 0; i < s.length(); i++) {
            if (i != 0 && s[i] == s[i - 1]) {
                continue;
            }
            longestPalindromeHelper(s, i);
        }

        return this->resultLength == 0 ? "" :
               s.substr(startIndex, resultLength);
    }

private:
    int resultLength;
    int startIndex;

    void longestPalindromeHelper(string s, string::size_type middleIndex) {

        int leftIndex = middleIndex, rightIndex = middleIndex;
        while (rightIndex < s.length() && s[rightIndex] == s[leftIndex]) {
            rightIndex++;
        }
        rightIndex--;

        while (leftIndex >= 0 && rightIndex < s.length()
               && s[leftIndex] == s[rightIndex]) {
            leftIndex--;
            rightIndex++;
        }

        int currentResultLength = rightIndex - leftIndex - 1;

        if (currentResultLength > resultLength) {
            resultLength = currentResultLength;
            startIndex = leftIndex + 1;
        }
    }
};

int main(int argc, char** args) {

    string s1 = "babad", s2 = "cbbd";

    Solution solution = Solution();

    //cout << solution.longestPalindrome(s1) << "\n";
    cout << solution.longestPalindrome(s2) << "\n";

    return 0;
}
