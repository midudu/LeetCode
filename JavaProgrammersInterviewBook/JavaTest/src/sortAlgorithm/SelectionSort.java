package sortAlgorithm;


import java.util.Arrays;
import java.util.List;

class SelectionSort {
	
	public static void selectionSort(int[] nums) {
		
		if ( nums == null || nums.length <= 1 ) {
			return;
		}
		
		int numsLength = nums.length;
		
		for (int i = 0; i < numsLength - 1; i++) {
			
			int index = i;
			
			for ( int j = i + 1; j < numsLength; j++ ) {
				
				if ( nums[j] < nums[index] ) {
					index = j;
				}
			}
			
			int temp = nums[i];
			nums[i] = nums[index];
			nums[index] = temp;
		}
	}
	
	public static void main(String[] args) {
		
		
		int[] nums = {2,7,4,2,3,9,-1,9,18};
		
		selectionSort(nums);
		
		System.out.println("haha");
	}
}