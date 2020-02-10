/*
  Write a function to find the longest common prefix string amongst an array of
strings.

  If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""

Explanation: There is no common prefix among the input strings.

Note:
  All given inputs are in lowercase letters a-z.
*/

#include <string>
#include <vector>
#include <iostream>

using namespace std;


class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        if (strs.empty()) {
            return string("");
        }

        int endIndex = 0;
        bool breakFlag = false;
        char ch;

        while (true) {
            if (strs.front().size() == endIndex) {
                break;
            }
            ch = strs.front()[endIndex];

            for (int i = 1; i < (int) strs.size(); i++) {
                if (strs[i].size() == endIndex || strs[i][endIndex] != ch) {
                    breakFlag = true;
                    break;
                }
            }

            if (breakFlag) {
                break;
            }

            endIndex++;
        }

        return endIndex ? strs.front().substr(0, endIndex) : string("");
    }
};


int main() {

    Solution solution;

    //vector<string> input = {"flower", "flow", "flight"};
    vector<string> input = {"dog","racecar","car"};
    std::cout << solution.longestCommonPrefix(input);

    return 0;
}
