package array;

class FindKMinimumNumbersInUnsortedArray {

    public static Integer findKMinimumNumbers(int[] nums, int k) {

        if (nums == null || k <= 0 || nums.length < k) {
            return null;
        }

        return findKMinimumNumbersHelper(nums, k, 0, nums.length - 1);
    }

    private static Integer findKMinimumNumbersHelper(
            int[] nums, int k,
            int startIndex, int endIndex) {

        int standardElement = nums[startIndex];

        int low = startIndex, high = endIndex;
        while (low < high) {

            while (low < high && nums[high] >= standardElement) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
                low++;
            }

            while (low < high && nums[low] <= standardElement) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
                high--;
            }
        }

        if (low == k - 1) {
            return standardElement;
        } else if (low < k - 1) {
            return findKMinimumNumbersHelper(nums, k, low + 1, endIndex);
        } else {
            return findKMinimumNumbersHelper(nums, k, startIndex, low - 1);
        }
    }


    public static void main(String[] args) {

        int[] nums = {5, 6, 1, -2, 7, 8, 3, 3, 2};

        int result = findKMinimumNumbers(nums, 4);

        System.out.println("haha");
    }
}