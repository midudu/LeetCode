package sortAlgorithm;

class HeapSort {
	
	public static void heapSort(int[] nums) {
		
		if ( nums == null || nums.length <= 1 ) {
			return;
		}
		
		int numsLength = nums.length;
		for ( int i = numsLength / 2 - 1; i >= 0; i-- ) {
			adjustToMaxHeap(nums, i, numsLength - 1);
		}
		
		for ( int i = numsLength - 1; i > 0; i-- ) {
			
			int temp = nums[i];
			nums[i] = nums[0];
			nums[0] = temp;
			
			adjustToMaxHeap( nums, 0, i - 1);
		}
	}
	
	
	private static void adjustToMaxHeap(int[] nums, int holeIndex, int maxAdjustIndexRange) {
		
		int leftChildIndex = holeIndex * 2 + 1;
		int rightChildIndex = holeIndex * 2 + 2;
		
		if ( leftChildIndex > maxAdjustIndexRange ) {
			return;
		}
		
		int targetIndex;
		if ( rightChildIndex <= maxAdjustIndexRange 
		&& nums[rightChildIndex] > nums[leftChildIndex] ) {
			targetIndex = rightChildIndex;
		} else {
			targetIndex = leftChildIndex;
		}
		
		if ( nums[targetIndex] > nums[holeIndex] ) {
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