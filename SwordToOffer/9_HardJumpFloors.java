/* 
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。 */

public class Solution {
    public int JumpFloorII(int target) {
		
		// f(0) = 1, f(n) = f(0) + f(1) + ... + f(n-1)
        
        if ( target <= 0 ) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        
        int result = 1;
        
        return (result<<(target - 1));
    }
}    