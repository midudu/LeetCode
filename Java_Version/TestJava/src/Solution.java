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