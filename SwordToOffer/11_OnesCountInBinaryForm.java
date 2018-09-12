/* 

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。 */

public class Solution {
    public int NumberOf1(int n) {
        
        int result = 0;
        
        while (n!=0) {
            
            int temp = n & 1;
            if (temp != 0) {
                result++;
            }
            
            n >>>= 1;
        }
        
        return result;
    }
}