/* 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39 */

public class Solution {
    public int Fibonacci(int n) {
        
        if (n<=0) {
            return 0;
        }
        
        if (n==1 || n==2){
            return 1;
        }
        
        int[] fibonacci = new int[n];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        
        return fibonacci[n-1];
    }
}