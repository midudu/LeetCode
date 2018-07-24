/* 统计一个数字在排序数组中出现的次数。 */

public class Solution {

    public static void main(String[] args) {

        int[] array = {3,3,3,3,4,5};

        int result = new Solution().GetNumberOfK(array, 3);
    }

    public int GetNumberOfK(int[] array, int k) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int k_index = findK(array, k);
        if (k_index == -1) {
            return 0;
        }

        int first_less_k_index = findFirstLessThanKIndex(array, 0, k_index, k);

        int first_more_k_index = findFirstMoreThanKIndex(array, k_index, array.length - 1, k);
        if (first_more_k_index == -1) {
            first_more_k_index = array.length;
        }

        return (first_more_k_index - first_less_k_index - 1);
    }

    private int findK(int[] array, int k) {

        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex <= endIndex) {
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == k) {
                return middleIndex;
            } else if (array[middleIndex] < k) {
                startIndex = middleIndex + 1;
            } else {
                endIndex = middleIndex - 1;
            }
        }

        return -1;
    }

    private int findFirstLessThanKIndex(int[] array, int startIndex, int endIndex, int k) {

        if (array[startIndex] == k) {
            return -1;
        }

        while (startIndex < endIndex - 1) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] < k) {
                startIndex = middleIndex;
            } else {
                endIndex = middleIndex - 1;
            }
        }

        return (array[endIndex] == k ? startIndex : endIndex);
    }

    private int findFirstMoreThanKIndex(int[] array, int startIndex, int endIndex, int k) {

        if (array[endIndex] == k) {
            return -1;
        }

        while (startIndex < endIndex - 1) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] > k) {
                endIndex = middleIndex;
            } else {
                startIndex = middleIndex + 1;
            }
        }

        return (array[startIndex] != k ? startIndex : endIndex);
    }
}