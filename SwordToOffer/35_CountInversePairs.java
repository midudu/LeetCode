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