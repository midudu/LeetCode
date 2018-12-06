package sortAlgorithm;

// 希尔排序相当于每次都在进行插入排序，步长一开始较大，先形成每隔step的有序子序列；然后不断缩小步长
// 直到步长为 1时完全有序

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