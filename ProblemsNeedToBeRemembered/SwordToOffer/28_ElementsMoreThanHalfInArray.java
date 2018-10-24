/* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。 */

// Method 1: O(nlogn) but easy to understand

/* import java.util.Arrays;
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
} */

// Method 2: O(n) but hard to understand

public class Solution {
	
	// 如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
    public int MoreThanHalfNum_Solution(int[] numbers) {
		
        if(numbers == null || numbers.length == 0) {
			return 0;
		}
		
        // 遍历每个元素，并记录次数；若与前一个元素相同，则次数加1，否则次数减1
        int result = numbers[0];
        int times = 1; // 次数
         
        for( int i = 1; i < numbers.length; ++i ) {
			
            if (times == 0) {
                // 更新result的值为当前元素，并置次数为1
                result = numbers[i];
                times = 1;
            } else if(numbers[i] == result) {
                ++times; // 相同则加1
            } else {
                --times; // 不同则减1               
            }
        }
         
        // 判断result是否符合条件，即出现次数大于数组长度的一半
        times = 0;
        for(int i = 0;i < numbers.length; ++i) {
            
			if(numbers[i] == result){
				++times;
			}
        }
         
        return (times > numbers.length / 2) ? result : 0;
    }
}

