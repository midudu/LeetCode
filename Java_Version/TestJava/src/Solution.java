public class Solution {

    private long inversePairsNumber = 0;

    public int InversePairs(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        mergeSortHelper(array, 0, array.length - 1);

        return (int)(inversePairsNumber%1000000007);
    }

    private void mergeSortHelper(int[] nums, int startIndex, int endIndex) {

        if (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            mergeSortHelper(nums, startIndex, middleIndex);
            mergeSortHelper(nums, middleIndex + 1, endIndex);
            mergeProcess(nums, startIndex, middleIndex, endIndex);
        }
    }

    private void mergeProcess(int[] nums, int startIndex,
                                     int middleIndex, int endIndex) {

        int leftIndex = startIndex, rightIndex = middleIndex + 1;
        int newNumsIndex = 0;
        int[] newNums = new int[endIndex - startIndex + 1];

        while (leftIndex <= middleIndex && rightIndex <= endIndex) {

            if (nums[leftIndex] <= nums[rightIndex]) {
                newNums[newNumsIndex] = nums[leftIndex];
                leftIndex++;
            } else {
                newNums[newNumsIndex] = nums[rightIndex];
                rightIndex++;
                inversePairsNumber += (middleIndex - leftIndex + 1);
            }
            newNumsIndex++;
        }


        if (leftIndex <= middleIndex) {
            System.arraycopy(nums, leftIndex,
                    nums, startIndex + newNumsIndex,
                    middleIndex - leftIndex + 1);
        }
        System.arraycopy(newNums, 0, nums, startIndex, newNumsIndex);
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int result = solution.InversePairs(new int[]{1,5,3,2,6});

        System.out.print(result);
    }
}