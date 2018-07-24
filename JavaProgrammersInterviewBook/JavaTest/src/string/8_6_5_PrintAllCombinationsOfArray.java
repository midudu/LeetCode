/* 给定一个数组[1,2,3,4,5,2],输出它的所有排列组合，其中3和5不能相连且4不能出现在第4个位置 */

package string;

import java.util.HashSet;

class PrintAllCombinationsOfArray {

    private static HashSet<String> stringHashSet = new HashSet<>();

    public static void printAllCombinationsOfArray(int[] nums) {

        printAllCombinationsOfArrayHelper(nums, 0, "");
    }

    private static void printAllCombinationsOfArrayHelper(int[] nums, int startIndex,
                                                          String lastPart) {

        if (startIndex == nums.length - 1) {
            if (lastPart.charAt(lastPart.length() - 1) == '3'
                    || lastPart.charAt(lastPart.length() - 1) == '5') {

                if (nums[startIndex] == 3 || nums[startIndex] == 5) {
                    return;
                }
            }

            String finalString = lastPart + Integer.toString(nums[startIndex]);

            if (!stringHashSet.contains(finalString)) {
                stringHashSet.add(finalString);
                System.out.println(finalString);
            }
            return;
        }


        for (int i = startIndex; i < nums.length; i++) {

            if (lastPart.length() >= 1) {
                if (lastPart.charAt(lastPart.length() - 1) == '3'
                        || lastPart.charAt(lastPart.length() - 1) == '5') {

                    if (nums[i] == 3 || nums[i] == 5) {
                        continue;
                    }
                }
            }

            int temp = nums[startIndex];
            nums[startIndex] = nums[i];
            nums[i] = temp;
            printAllCombinationsOfArrayHelper(nums, startIndex + 1,
                    lastPart + Integer.toString(nums[startIndex]));
            temp = nums[startIndex];
            nums[startIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 2};
        printAllCombinationsOfArray(nums);

        System.out.println("haa");
    }
}