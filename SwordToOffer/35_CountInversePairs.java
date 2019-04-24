/* 
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组, 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P % 1000000007
输入描述:
题目保证输入的数组中没有的相同的数字

数据范围：

对于 % 50的数据, size <= 10 ^ 4

对于 % 75的数据, size <= 10 ^ 5

对于 % 100的数据, size <= 2 * 10 ^ 5

示例1
输入
1, 2, 3, 4, 5, 6, 7, 0
输出
7 */

public class Solution {

    public int InversePairs(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int[] currentResult = new int[1];

        mergeSortHelper(array, 0, array.length - 1,
                currentResult);

        return currentResult[0];
    }

    private void mergeSortHelper(
            int[] nums, int startIndex, int endIndex,
            int[] currentResult) {

        if (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            mergeSortHelper(nums, startIndex, middleIndex,
                    currentResult);

            mergeSortHelper(nums, middleIndex + 1, endIndex,
                    currentResult);

            mergeProcess(nums, startIndex, middleIndex, endIndex, currentResult);
        }
    }

    private void mergeProcess(
            int[] nums, int startIndex, int middleIndex, int endIndex,
            int[] currentResult) {

        int leftIndex = startIndex, rightIndex = middleIndex + 1;
        int newNumbersIndex = 0;

        int[] newNumbers = new int[endIndex - startIndex + 1];

        while (leftIndex <= middleIndex && rightIndex <= endIndex) {

            if (nums[leftIndex] <= nums[rightIndex]) {
                newNumbers[newNumbersIndex] = nums[leftIndex];
                leftIndex++;
            } else {
                newNumbers[newNumbersIndex] = nums[rightIndex];
                rightIndex++;

                int currentInversePairNumber = middleIndex - leftIndex + 1;

                if (currentResult[0] >= 1000000007 - currentInversePairNumber) {
                    currentResult[0] = currentResult[0]
                            - 1000000007 + currentInversePairNumber;
                } else {
                    currentResult[0] += currentInversePairNumber;
                }
            }

            newNumbersIndex++;
        }

        if (leftIndex <= middleIndex) {
            System.arraycopy(nums, leftIndex,
                    nums, startIndex + newNumbersIndex,
                    middleIndex - leftIndex + 1);
        }

        System.arraycopy(newNumbers, 0, nums, startIndex, newNumbersIndex);
    }
}