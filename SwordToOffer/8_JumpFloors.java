/* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。 */

public class Solution {
    public int JumpFloor(int target) {
        
        if (target <= 0) {
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        
        int[] methods = new int[target];
        methods[0] = 1;
        methods[1] = 2;
        
        for (int i = 2; i < target; i++) {
            methods[i] = methods[i-1]+methods[i-2];
        }
        
        return methods[target-1];
    }
}