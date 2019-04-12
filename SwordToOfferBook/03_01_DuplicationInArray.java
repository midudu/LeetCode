// 找到数组中重复的数字

//在一个长度为n的数组内所有数字都在0-n-1的范围内。数组中某些数字是重复的，但不知道
//有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。如果
//没有重复数字返回-1

// TC: O(n)
// SC: O(1)

class Solution {

    public int ifHasDuplicationInArray(int[] nums) {

        if (nums == null || nums.length < 2) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] != i) {

                int currentNum = nums[i];
                int anotherNum = nums[currentNum];

                if (currentNum > nums.length - 1 || anotherNum > nums.length - 1) {
                    return -1;
                }

                if (currentNum == anotherNum) {
                    return currentNum;
                }

                nums[i] = anotherNum;
                nums[currentNum] = currentNum;
            }
        }

        return -1;
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

        int result = new Solution().ifHasDuplicationInArray(nums);

        if (ifContainsElement(expectedResult, result)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }
}