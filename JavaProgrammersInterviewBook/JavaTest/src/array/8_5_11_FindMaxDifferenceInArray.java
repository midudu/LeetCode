/* 数组中的一个数字减去它 右边子数组的一个数字可以得到一个差值，求所有差值中的最大值 */

package array;

class FindMaxDifferenceInArray {

    public static int findMaxDifferenceInArray(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int maxValue = nums[0];
        int maxDifference = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > maxValue) {
                maxValue = nums[i];
            } else {
                maxDifference = Math.max(maxDifference, maxValue - nums[i]);
            }
        }

        return maxDifference;
    }


    public static void main(String[] args) {

        int[] nums = {1, 4, 17, 3, 2, 9};

        System.out.println(findMaxDifferenceInArray(nums));
    }
}