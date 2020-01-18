/*
  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
of rows like this: (you may want to display this pattern in a fixed font for
better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R

  And then read line by line: "PAHNAPLSIIGYIR"

  Write the code that will take a string and make this conversion given a
number of rows:
  string convert(string s, int numRows);

Example 1:

  Input: s = "PAYPALISHIRING", numRows = 3
  Output: "PAHNAPLSIIGYIR"

Example 2:

  Input: s = "PAYPALISHIRING", numRows = 4
  Output: "PINALSIGYAHRPI"

Explanation:

P   I  N
A  LS IG
YA  HR
P   I
*/

#include <string>
#include <algorithm>
#include <vector>

#include <iostream>

using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        if (s.empty() || numRows < 2) {
            return s;
        }

        vector<string> resultArray(min(numRows, static_cast<int>(s.length())));

        bool isDown = true;
        int currentRow = -1;
        for (char ch : s) {
            if (isDown) {
                currentRow++;
                resultArray[currentRow] += ch;
                if (currentRow == numRows - 1) {
                    isDown = false;
                }
            } else {
                currentRow--;
                resultArray[currentRow] += ch;
                if (currentRow == 0) {
                    isDown = true;
                }
            }
        }

        string result;
        for (const string &str : resultArray) {
            result += str;
        }

        return result;
    }
};


int main(int argc, char **args) {

    Solution solution = Solution();
    string s = "PAYPALISHIRING";

    cout << solution.convert(s, 3) << "\n";
    cout << solution.convert(s, 4) << "\n";

    return 0;
}
