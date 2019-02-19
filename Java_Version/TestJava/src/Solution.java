/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid
but "(]" and "([)]" are not.*/

class Solution {

    public boolean isValid(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        char[] map = new char[256];
        map[')'] = '(';
        map['}'] = '{';
        map[']'] = '[';

        char[] stack = new char[s.length()];
        int currentIndex = -1;

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{'
                    || currentChar == '[') {
                currentIndex++;
                stack[currentIndex] = currentChar;
            } else {
                if (currentIndex == -1) {
                    return false;
                } else {
                    if (stack[currentIndex] == map[currentChar]) {
                        currentIndex--;
                    } else {
                        return false;
                    }
                }
            }
        }

        return currentIndex == -1;

    }
}