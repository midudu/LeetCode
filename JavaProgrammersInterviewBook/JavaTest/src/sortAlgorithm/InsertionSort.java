package sortAlgorithm;

class InsertionSort {

    public static void insertionSort(int[] nums) {
		
		if ( nums == null || nums.length <= 1 ) {
			return;
		}

        int numsLength = nums.length;

        for (int i = 1; i < numsLength; i++) {

            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = temp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 4, 2, 3, 9, -1, 9, 18};

        insertionSort(nums);

        System.out.println("haha");
    }
}