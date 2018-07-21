/* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。 */

import java.util.Arrays;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        
        if (array == null || array.length == 0) {
			return 0;
		}
		
		Arrays.sort(array);
		
		int result = array[array.length/2];
		int startIndex = 0;
		for (int i = 0; i <= array.length/2; i++) {
			
			if ( array[i] == result ) {
				startIndex = i;
				break;
			}
		}
		
		int endIndex = 0;
		for (int i = array.length - 1; i >= array.length / 2; i-- ) {
			
			if ( array[i] == result ) {
				endIndex = i;
				break;
			}
		}
		
		if (  endIndex - startIndex + 1> array.length / 2 ) {
			return result;
		} else {
			return 0;
		}
    }
}