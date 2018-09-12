/* 
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。 */

public class Solution {
    public void reOrderArray(int [] array) {
        
        if (array == null || array.length == 0) {
            return;
        }
        
        int oddNumbersCount = 0;
        
        for (int i = 0; i < array.length; i++) {
            if ( array[i] % 2 == 1 ) {
                oddNumbersCount++;
            }
        }
        
        int[] newArray = new int[array.length];
        
        int oddPointer = 0;
        int evenPointer = oddNumbersCount;
        for (int i = 0; i < array.length; i++) {
            if ( array[i] % 2 == 1 ) {
                newArray[oddPointer] = array[i];
                oddPointer++;
            } else {
                newArray[evenPointer] = array[i];
                evenPointer++;
            }
        }
        
        System.arraycopy(newArray,0,array,0,array.length);
    }
}