// 不修改数组找到数组中重复的数字

//在一个长度为n+1的数组内所有数字都在1-n的范围内。数组中某些数字是重复的，但不知道
//有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。


class Solution {

    // Method 1:
    // TC: O(n)
    // SC: O(n)
    public int ifHasDuplicationInArrayNoEdit1(int[] nums) {

        if (nums == null || nums.length < 2) {
            throw new UnsupportedOperationException("No duplicate number!");
        }

        int n = nums.length - 1;
        int[] hashTable = new int[n];

        for (int num : nums) {

            if (hashTable[num - 1] != 0) {
                return num;
            }

            hashTable[num - 1]++;
        }

        throw new UnsupportedOperationException("No duplicate number!");
    }

    // Method 1:
    // TC: O(nlogn)
    // SC: O(1)
    public int ifHasDuplicationInArrayNoEdit2(int[] nums) {

        if (nums == null || nums.length < 2) {
            throw new UnsupportedOperationException("No duplicate number!");
        }

        int n = nums.length - 1;

        int start = 1, end = n;

        while (start <= end) {

            int middle = ((end - start) >> 1) + start;

            int expected = middle - start + 1;
            int actual = countNumbersWithinRange(nums, start, middle);

            if (start == end) {
                if (expected == actual) {
                    throw new UnsupportedOperationException("No duplicate number!");
                } else {
                    return start;
                }
            }

            if (expected != actual) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        throw new UnsupportedOperationException("No duplicate number!");
    }

    private int countNumbersWithinRange(int[] nums, int start, int end) {

        if (start > end) {
            throw new UnsupportedOperationException();
        }

        int result = 0;

        for (int num : nums) {

            if (num >= start && num <= end) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] nums = {{2, 1, 3, 1, 4},
                {2, 4, 3, 1, 4},
                {2, 4, 2, 1, 4},
                {2, 1, 3, 0, 4},
                {2, 1, 3, 5, 4},
                null};

        int[][] expectedResults = {{1}, {4}, {2, 4}, {-1}, {-1}, {-1}};

        for (int i = 0; i < nums.length; i++) {
            test(nums[i], expectedResults[i]);
        }

    }

    private static boolean ifContainsElement(int[] nums, int element) {

        for (int num : nums) {
            if (num == element) {
                return true;
            }
        }

        return false;
    }

    private static void test(int[] nums, int[] expectedResult) {

        int result = new Solution().ifHasDuplicationInArrayNoEdit1(nums);

        if (ifContainsElement(expectedResult, result)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }
}