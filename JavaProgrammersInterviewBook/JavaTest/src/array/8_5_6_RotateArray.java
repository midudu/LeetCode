package array;

class RotateArray {

    public static void rotateArray(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int numsLength = nums.length;
        k = k % numsLength;


        reverseArray(nums, 0, k);
        reverseArray(nums, k, numsLength - k);
        reverseArray(nums, 0, numsLength);
    }


    private static void reverseArray(int[] nums, int startIndex, int reverseLength) {

        int endIndex = startIndex + reverseLength - 1;
        while (startIndex < endIndex) {

            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        rotateArray(nums, 6);
        rotateArray(nums, 2);
        rotateArray(nums, 13);

        System.out.println("haha");
    }
}