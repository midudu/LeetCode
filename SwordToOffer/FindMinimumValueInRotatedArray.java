/* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
  
  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
  
  NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。 */

import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        
        if ( array == null || array.length == 0 ) {
            return 0;
        }
        
        if (array.length == 1) {
            return array[0];
        }
        
        int startIndex = 0;
        int endIndex = array.length - 1;
        
        while (startIndex < endIndex) {
            if (endIndex - startIndex == 1) {
                return Math.min(array[startIndex], array[endIndex]);
            }
            
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if ( array[midIndex] >= array[startIndex] ) {
                startIndex = midIndex;
            } else {
                endIndex = midIndex;
            }
        }
        
        return Math.min(array[startIndex], array[endIndex]);
    }
}