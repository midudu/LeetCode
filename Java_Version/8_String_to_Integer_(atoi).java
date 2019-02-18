/*Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge,
please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given
input specs). You are responsible to gather all the input requirements up
front.


Requirements for atoi:

  The function first discards as many whitespace characters as necessary
until the first non-whitespace character is found. Then, starting from this
character, takes an optional initial plus or minus sign followed by as many
numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the
integral number, which are ignored and have no effect on the behavior of this
function.

If the first sequence of non-whitespace characters in str is not a valid
integral number, or if no such sequence exists because either str is empty or
it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the
correct value is out of the range of representable values, INT_MAX (2147483647)
or INT_MIN (-2147483648) is returned.*/



class Solution {

    public int myAtoi(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        int currentIndex = 0;
        while (currentIndex < str.length()
                && str.charAt(currentIndex) == ' ') {
            currentIndex++;
        }

        if (currentIndex == str.length()) {
            return 0;
        }


        boolean isPositive = true;
        if (str.charAt(currentIndex) == '+') {
            currentIndex++;
        } else if (str.charAt(currentIndex) == '-') {
            isPositive = false;
            currentIndex++;
        }

        return isPositive ?
                handlePositiveInteger(str, currentIndex) :
                handleNegativeInteger(str, currentIndex);
    }

    private int handlePositiveInteger(
            String str, int startIndex) {

        long result = 0;

        while (startIndex < str.length()) {

            char currentChar = str.charAt(startIndex);

            if (currentChar >= '0' && currentChar <= '9') {

                result = result * 10 + (currentChar - '0');

                if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

            } else {
                break;
            }

            startIndex++;
        }

        return (int) result;
    }

    private int handleNegativeInteger(
            String str, int startIndex) {

        long result = 0;

        while (startIndex < str.length()) {

            char currentChar = str.charAt(startIndex);

            if (currentChar >= '0' && currentChar <= '9') {

                result = result * 10 - (currentChar - '0');

                if (result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

            } else {
                break;
            }

            startIndex++;
        }

        return (int) result;
    }
}