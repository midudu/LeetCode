package sortAlgorithm;

class ShellSort {

    public static void shellSort(int[] nums) {

        if (nums == null || nums.length <= 1) {
            return;
        }

        for (int step = nums.length / 2; step > 0; step /= 2) {

            for (int i = step; i < nums.length; i += step) {
                int temp = nums[i];
                int j = i - step;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + step] = nums[j];
                    j -= step;
                }
                nums[j + step] = temp;
            }
        }
    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 4, 2, 3, 9, -1, 9, 18};

        shellSort(nums);

        System.out.println("haha");
    }
}