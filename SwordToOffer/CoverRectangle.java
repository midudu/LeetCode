/* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？ */

public class Solution {
    public int RectCover(int target) {
        
        if ( target <= 0) {
            return 0;
        }
        
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            int[] result = new int[target];
            result[0] = 1;
            result[1] = 2;
            
            for (int i = 2; i < target; i++) {
                result[i] = result[i - 1] + result[i - 2];         //类似于Fibonacci数列，因为f(n)要么最后一列竖着放，此时等效于f(n-1);
                                                                // 要么最后两列横着放，此时等效于f(n-2)。最后两列都竖着放的情况已经包括
                                                                // 在f(n-1)内了
            }
            
            return result[target-1];
        }
    }
}