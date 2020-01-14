/*
  Given a string, find the length of the longest substring without repeating
characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.

  Note that the answer must be a substring, "pwke" is a subsequence and not a
substring.
*/

#include <string>
#include <iostream>

using namespace std;

#define max(x, y) x > y ? x : y;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {

        if (s.length() == 0) {
            return 0;
        }

        int result = 0;
        int startIndex = 0;

        int map[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s[i];
            if (map[ch] != -1) {
                startIndex = max(startIndex, map[ch] + 1);
            }
            result = max(result, i - startIndex + 1);
            map[ch] = i;
        }

        return result;
    }
};

int main(int argc, char **args) {

    string inputs[3] = {"abcabcbb", "bbbbb", "pwwkew"};
    int result[3] = {3, 1, 3};

    Solution solution = Solution();

    for (string input : inputs) {
        cout << solution.lengthOfLongestSubstring(input) << "\n";
    }

    return 0;
}

