/*
Given a string of numbers and operators,

return all possible results from computing all the different possible ways
to group numbers and operators. The valid operators are +, - and *.

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

    public static void main(String[] args) {

        String input = "12-1-1";

        List<Integer> result =
                new Solution().diffWaysToCompute(input);

        System.out.println();
    }

    public List<Integer> diffWaysToCompute(String input) {

        if (input == null || input.length() == 0) {

            return new ArrayList<>();
        }

        ArrayList<Integer> operatorList = new ArrayList<>();
        operatorList.add(-1);
        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                operatorList.add(i);
            }
        }
        operatorList.add(input.length());

        return diffWaysToComputeHelper(
                input, operatorList,
                0, operatorList.size() - 1);
    }

    private List<Integer> diffWaysToComputeHelper(
            String input, ArrayList<Integer> operatorList,
            int startIndex, int endIndex) {

        if (startIndex == endIndex - 1) {

            List<Integer> result = new ArrayList<>();

            String subString = input.substring(
                    operatorList.get(startIndex) + 1,
                    operatorList.get(endIndex));
            result.add(Integer.valueOf(subString));
            return result;
        }

        List<Integer> result = new ArrayList<>();

        for (int index = startIndex + 1; index < endIndex; index++) {

            List<Integer> result1 = diffWaysToComputeHelper(
                    input, operatorList, startIndex, index);
            List<Integer> result2 = diffWaysToComputeHelper(
                    input, operatorList, index, endIndex);

            char operator = input.charAt(operatorList.get(index));

            for (int i = 0; i < result1.size(); i++) {
                for (int j = 0; j < result2.size(); j++) {

                    if (operator == '+') {
                        result.add(result1.get(i) + result2.get(j));
                    } else if (operator == '-') {
                        result.add(result1.get(i) - result2.get(j));
                    } else {
                        result.add(result1.get(i) * result2.get(j));
                    }
                }
            }
        }

        return result;
    }
}
