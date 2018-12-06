// 有一个升序排列的数组，寻找数组中元素绝对值最小的数

package array;

class FindMinAbsoluteValueNumber {

    public static Integer findMinAbsoluteValueNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int startIndex = 0, endIndex = nums.length - 1;

        while (true) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[middleIndex] == 0) {
                return 0;
            } else if (nums[middleIndex] < 0) {
                if (middleIndex == endIndex || middleIndex + 1 == endIndex) {
                    int temp1 = Math.abs(middleIndex);
                    int temp2 = Math.abs(endIndex);
                    return temp1 < temp2 ? nums[middleIndex] : nums[endIndex];
                } else {
                    startIndex = middleIndex;
                }
            } else if (nums[middleIndex] > 0) {
                if (middleIndex == startIndex || middleIndex - 1 == endIndex) {
                    int temp1 = Math.abs(middleIndex);
                    int temp2 = Math.abs(startIndex);
                    return temp1 < temp2 ? nums[middleIndex] : nums[startIndex];
                } else {
                    endIndex = middleIndex;
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {-10, -5, -2, 7, 15, 50};
        System.out.println(findMinAbsoluteValueNumber(nums));
    }
}