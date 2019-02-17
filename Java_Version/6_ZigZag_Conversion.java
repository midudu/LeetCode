/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of
rows like this:
(you may want to display this pattern in a fixed font for better legibility)

        P   A   H   N
        A P L S I I G
        Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number
of rows:

        string convert(string s, int numRows);

        Example 1:

        Input: s = "PAYPALISHIRING", numRows = 3
        Output: "PAHNAPLSIIGYIR"
        Example 2:

        Input: s = "PAYPALISHIRING", numRows = 4
        Output: "PINALSIGYAHRPI"
        Explanation:

        P     I    N
        A   L S  I G
        Y A   H R
        P     I
*/

// Method 1
/*class Solution {

    public String convert(String s, int numRows) {

        if (s == null || s.isEmpty() || numRows <= 1) {
            return s;
        }

        int groupColumns = numRows - 1;

        StringBuilder[] rowResult = new StringBuilder[numRows];

        int currentRowPosition = 0;
        int groupIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            if (rowResult[currentRowPosition] == null) {
                rowResult[currentRowPosition] = new StringBuilder();
            }

            rowResult[currentRowPosition].append(s.charAt(i));

            if (groupIndex == 0) {
                if (currentRowPosition != numRows - 1) {
                    currentRowPosition++;
                    continue;
                }
            }

            groupIndex = (groupIndex + 1 == groupColumns ? 0 : groupIndex + 1);

            if (groupIndex == 0) {
                currentRowPosition = 0;
            } else {
                currentRowPosition--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            if (rowResult[row] != null) {
                result.append(rowResult[row]);
            }
        }

        return result.toString();
    }
}*/


class Solution {

    public String convert(String s, int numRows) {

        if (s == null || s.isEmpty()
                || numRows <= 1
                || s.length() <= numRows) {
            return s;
        }

        char[] result = new char[s.length()];
        int newIndex = 0;
        int fixStep = 2 * (numRows - 1);

        for (int row = 0; row < numRows; row++) {

            int addedInterval = fixStep - 2 * row;

            for (int originalIndex = row; originalIndex < s.length();
                 originalIndex += fixStep) {

                // fill the fixed part
                result[newIndex] = s.charAt(originalIndex);
                newIndex++;

                // fill the unfixed part
                if (addedInterval > 0 && addedInterval < fixStep
                        && newIndex < s.length()
                        && originalIndex + addedInterval < s.length()) {

                    result[newIndex] = s.charAt(originalIndex + addedInterval);
                    newIndex++;
                }
            }
        }

        return new String(result);
    }
}
