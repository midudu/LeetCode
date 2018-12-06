package sortAlgorithm;

class HeapSort {

    public static void heapSort(int[] nums) {

        /* Step 1: At first, {@code nums} is regarded as a binary tree. For a
           node whose index is n, the left son's index is 2 * n + 1; and the
           right son's index is 2 * n + 2. 
           */
        if (nums == null || nums.length <= 1) {
            return;
        }

        /* Step 2: Now we will adjust {@code nums} to make it a Max-Heap: for
           every node, its value is larger than its left son's value and its
           right son's value. Because some nodes which are on the last of the
           array have no sons, we only need to adjust the non-leaf nodes.
              As for the adjustment order, we should firstly adjust the bottom
           nodes and then adjust the upper nodes. The reason is that if we find
           a node's value is larger than both its left son's value and its
           right son's value, this means the tree from the current node to
           bottom nodes has been a Max-Heap and we do not need to adjust it.
           */
        int numsLength = nums.length;
        for (int i = numsLength / 2 - 1; i >= 0; i--) {
            adjustToMaxHeap(nums, i, numsLength - 1);
        }

        /* Step 3: Now the array {@code nums} has become a Max-Heap. Next, we 
        just exchange nums[0] with the last element in {@code nums} (because
        nums[0] is the largest value in {@code nums}), and re-adjust the array
        to form a Max-Heap again. Note that the adjustment range is dynamically
        changed because the larger numbers has been placed at the back of the
        array 
        */
        for (int i = numsLength - 1; i > 0; i--) {

            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            adjustToMaxHeap(nums, 0, i - 1);
        }
    }


    private static void adjustToMaxHeap(
            int[] nums, int holeIndex, int maxAdjustIndexRange) {

        int leftChildIndex = holeIndex * 2 + 1;
        int rightChildIndex = holeIndex * 2 + 2;

        if (leftChildIndex > maxAdjustIndexRange) {
            return;
        }

        int targetIndex;
        if (rightChildIndex <= maxAdjustIndexRange
                && nums[rightChildIndex] > nums[leftChildIndex]) {
            targetIndex = rightChildIndex;
        } else {
            targetIndex = leftChildIndex;
        }

        if (nums[targetIndex] > nums[holeIndex]) {

            int temp = nums[targetIndex];
            nums[targetIndex] = nums[holeIndex];
            nums[holeIndex] = temp;

            adjustToMaxHeap(nums, targetIndex, maxAdjustIndexRange);
        }
    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 4, 2, 3, 9, -1, 9, 18};

        heapSort(nums);

        System.out.println("haha");
    }
}