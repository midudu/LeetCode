package sortAlgorithm;

class BubbleSort {

    public static void bubbleSort(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        int numsLength = nums.length;
        boolean flag = false;

        for (int i = 0; i < numsLength - 1; i++) {

            for (int j = numsLength - 1; j > i; j--) {

                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 4, 2, 3, 9, -1, 9, 18};

        bubbleSort(nums);

        System.out.println("haha");
    }
}