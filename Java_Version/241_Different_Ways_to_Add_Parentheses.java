/*
  Given a string of numbers and operators, return all possible results from
computing all the different possible ways to group numbers and operators. The
valid operators are +, - and *.

Example 1:

        Input: "2-1-1"
        Output: [0, 2]

        Explanation:

        ((2-1)-1) = 0
        (2-(1-1)) = 2

Example 2:

        Input: "2*3-4*5"
        Output: [-34, -14, -10, -10, 10]

        Explanation:

        (2*(3-(4*5))) = -34
        ((2*3)-(4*5)) = -14
        ((2*(3-4))*5) = -10
        (2*((3-4)*5)) = -10
        (((2*3)-4)*5) = 10
*/

import java.util.*;

class Solution {

    private static final int ADD_OPERATOR = 0;
    private static final int MINUS_OPERATOR = 1;
    private static final int MULTI_OPERATOR = 2;

    public static void main(String[] args) {

        String input = "2*3-4*5";

        List<Integer> result =
                new Solution().diffWaysToCompute(input);

        System.out.println();
    }

    public List<Integer> diffWaysToCompute(String input) {

        if (input == null || input.length() == 0) {

            return new ArrayList<>();
        }

        List<Integer> numbersList = new ArrayList<>();
        List<Integer> operatorsList = new ArrayList<>();

        int startIndex = 0;
        while (startIndex < input.length()) {
            int currentIndex = startIndex;
            while (currentIndex < input.length() &&
                    (input.charAt(currentIndex) >= '0' && input.charAt(currentIndex) <= '9')) {
                currentIndex++;
            }
            numbersList.add(Integer.valueOf(input.substring(startIndex, currentIndex)));
            if (currentIndex != input.length()) {
                if (input.charAt(currentIndex) == '+') {
                    operatorsList.add(ADD_OPERATOR);
                } else if (input.charAt(currentIndex) == '-') {
                    operatorsList.add(MINUS_OPERATOR);
                } else if (input.charAt(currentIndex) == '*') {
                    operatorsList.add(MULTI_OPERATOR);
                }
            }
            startIndex = currentIndex + 1;
        }

        if (numbersList.size() != operatorsList.size() + 1) {
            throw new RuntimeException("illegal input");
        }

        if (numbersList.size() == 1) {
            return numbersList;
        }

        return diffWaysToComputeHelper(numbersList, operatorsList,
                0, numbersList.size() - 1);
    }

    private int calculate(int num1, int num2, int operator) {

        if (operator == ADD_OPERATOR) {
            return num1 + num2;
        } else if (operator == MINUS_OPERATOR) {
            return num1 - num2;
        } else /*if (operator == MULTI_OPERATOR)*/ {
            return num1 * num2;
        }
    }

    private List<Integer> mergeResult(List<Integer> result1, List<Integer> result2, int operator) {

        List<Integer> result = new ArrayList<>(result1.size() * result2.size());
        for (int i = 0; i < result1.size(); i++) {
            for (int j = 0; j < result2.size(); j++) {
                result.add(calculate(result1.get(i), result2.get(j), operator));
            }
        }

        return result;
    }

    private List<Integer> diffWaysToComputeHelper(
            List<Integer> numbersList, List<Integer> operatorsList, int startIndex, int endIndex) {

        List<Integer> result = new ArrayList<>();

        if (startIndex == endIndex) {
            result.add(numbersList.get(startIndex));
            return result;
        }

        if (startIndex == endIndex - 1) {
            int num1 = numbersList.get(startIndex);
            int num2 = numbersList.get(endIndex);
            int operator = operatorsList.get(startIndex);
            result.add(calculate(num1, num2, operator));
            return result;
        }

        for (int i = startIndex; i < endIndex; i++) {

            List<Integer> result1 = diffWaysToComputeHelper(numbersList, operatorsList,
                    startIndex, i);
            List<Integer> result2 = diffWaysToComputeHelper(numbersList, operatorsList,
                    i + 1, endIndex);

            result.addAll(mergeResult(result1, result2, operatorsList.get(i)));
        }

        return result;
    }
}
