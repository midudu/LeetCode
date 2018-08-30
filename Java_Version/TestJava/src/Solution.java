/* 题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。 */

public class Solution {
    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }

        int startIndex = calculateStartIndex(str);
        if (startIndex == -1) {
            return false;
        }

        boolean eAllowableFlag = true;
        boolean minusAllowableFlag = true;
        boolean dotAllowableFlag = true;
        boolean addAllowableFlag = true;

        for (int i = startIndex; i < str.length; i++) {

            char currentChar = str[i];

            if (currentChar >= '0' && currentChar <= '9') {
                continue;
            } else if (currentChar == 'e' || currentChar == 'E') {
                if (eAllowableFlag) {
                    eAllowableFlag = false;
                    if (i == str.length - 1) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if (currentChar == '-') {
                if (i == str.length - 1) {
                    return false;
                }

                if (eAllowableFlag) {
                    return false;
                } else {
                    if (!addAllowableFlag) {
                        return false;
                    } else {
                        if (minusAllowableFlag) {
                            minusAllowableFlag = false;
                        } else {
                            return false;
                        }
                    }
                }
            } else if (currentChar == '.') {
                if (!dotAllowableFlag) {
                    return false;
                } else {
                    dotAllowableFlag = false;

                    if (eAllowableFlag) {
                        if (i == str.length - 1 || (!(str[i + 1] >= '0' && str[i + 1] <= '9'))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }

            } else if (currentChar == '+') {
                if (i == str.length - 1) {
                    return false;
                }
                if (!addAllowableFlag) {
                    return false;
                } else {
                    addAllowableFlag = false;
                    if (eAllowableFlag) {
                        return false;
                    }
                    if (!minusAllowableFlag) {
                        return false;
                    }
                }

            } else {
                return false;
            }
        }

        return true;
    }

    private int calculateStartIndex(char[] str) {

        if (str[0] == '+') {
            if (str.length == 1) {
                return -1;
            } else {
                return 1;
            }
        } else if (str[0] == '-') {
            if (str.length == 1) {
                return -1;
            } else {
                return 1;
            }
        } else if (str[0] >= '1' && str[0] <= '9') {
            return 0;
        } else if (str[0] == '0') {
            if (str.length == 1) {
                return 0;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        boolean result = new Solution().isNumeric("123.45e+6".toCharArray());

        System.out.println("");
    }
}