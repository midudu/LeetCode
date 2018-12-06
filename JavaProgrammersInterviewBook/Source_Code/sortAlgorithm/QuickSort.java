package sortAlgorithm;

class QuickSort {
	
	public static void quickSort(int[] nums) {
		
		if ( nums == null || nums.length <= 1 ) {
			return;
		}
		
		quickSortHelper(nums, 0, nums.length - 1);
	}
	
	
	private static void quickSortHelper(int[] nums,  int startIndex, int endIndex) {
		
		if ( startIndex >= endIndex ) {
			return;
		}
		
		int standardElement = nums[startIndex];
		
		int low = startIndex;
		int high = endIndex;
		
		while ( low < high ) {
			
			while ( low < high && nums[high] >= standardElement ) {
				high--;
			}
			if ( low < high ) {
				nums[low] = nums[high];
				low++;
			}
			
			while ( low < high && nums[low] <= standardElement ) {
				low++;
			}
			if ( low < high ) {
				nums[high] = nums[low];
				high--;
			}
		}
		nums[low] = standardElement;
		
		quickSortHelper(nums, startIndex, low - 1);
		quickSortHelper(nums, low+1, endIndex);
	}
	
	public static void main(String[] args) {

        int[] nums = {2, 7, 4, 2, 3, 9, -1, 9, 18};

        quickSort(nums);

        System.out.println("haha");
    }
}