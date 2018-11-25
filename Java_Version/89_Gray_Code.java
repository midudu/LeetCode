/*
The gray code is a binary numeral system where two successive values differ in
only one bit.

Given a non-negative integer n representing the total number of bits in the
code, print the sequence of gray code. A gray code sequence must begin with 0.

        Example 1:

        Input: 2
        Output: [0,1,3,2]
        Explanation:
        00 - 0
        01 - 1
        11 - 3
        10 - 2

For a given n, a gray code sequence may not be uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence.

        00 - 0
        10 - 2
        11 - 3
        01 - 1
        Example 2:

        Input: 0
        Output: [0]

Explanation: We define the gray code sequence to begin with 0.

A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 = 1.

Therefore, for n = 0 the gray code sequence is [0].*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// Method 1: Slow but easy
/* class Solution {
    
    public List<Integer> grayCode(int n) {

        if (n < 0) {
            return new ArrayList<>();
        }

        int[] weights = new int[n];
        int totalNumbers = 0;
        int currentWeight = 1;
        for (int i = 0; i < n; i++) {

            totalNumbers += currentWeight;
            weights[i] = currentWeight;

            currentWeight *= 2;
        }

        List<Integer> result = new ArrayList<>();
        result.add(0);
        HashSet<Integer> existingNumbers = new HashSet<>();
        existingNumbers.add(0);

        boolean[] lastCodeStructure = new boolean[n];

        grayCodeHelper(1, totalNumbers, lastCodeStructure, weights,
                result, existingNumbers);

        return result;
    }

    private void grayCodeHelper(
            int currentNumber, int totalNumbers,
            boolean[] lastCodeStructure, int[] weights,
            List<Integer> result, HashSet<Integer> existingNumbers) {

        if (currentNumber > totalNumbers) {
            return;
        }

        for (int i = 0; i < lastCodeStructure.length; i++) {

            lastCodeStructure[i] = (!lastCodeStructure[i]);

            int currentNum = calculateInteger(lastCodeStructure, weights);

            if (!existingNumbers.contains(currentNum)) {

                existingNumbers.add(currentNum);
                result.add(currentNum);
                break;
            }

            lastCodeStructure[i] = (!lastCodeStructure[i]);
        }

        grayCodeHelper(currentNumber + 1, totalNumbers,
                lastCodeStructure, weights, result, existingNumbers);
    }

    private int calculateInteger(
            boolean[] currentNumberStructure, int[] weights) {

        int result = 0;

        for (int i = 0; i < weights.length; i++) {

            result += (currentNumberStructure[i] ? weights[i] : 0);
        }

        return result;
    }
} */


// Method 2: fast. The principle is mirror-symmetric to form gray code
class Solution {

    private int pow(int n) {
        return 1 << n;
    }

    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<>(pow(n));
        result.add(0);

        if (n == 0) {
            return result;
        }

        result.add(1);

        for (int i = 1; i < n; i++) {

            int p = pow(i);

            int index = 1;

            while (p - index >= 0) {
                result.add(result.get(p - index) + p);
                index++;
            }
        }

        return result;
    }
}
