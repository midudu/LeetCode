/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*Implement int sqrt(int x).

  Compute and return the square root of x.

   x is guaranteed to be a non-negative integer.


  Example 1:

   Input: 4

   Output: 2
  
  Example 2:

   Input: 8

   Output: 2
  
  Explanation: The square root of 8 is 2.82842..., and since we want to return an integer, the decimal part will be truncated.*/


 
* 
* 思想：

* (1) 直接调用库函数速度比较慢，所以使用二分法来做比较快

* (2) 为了防止溢出，示例代码中使用了除法比较代替了乘法比较

-------


    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int start = 1;
        int end = x;
        // Find the last postion whose square is <= x
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            //Same to mid * mid >x. Use divide to avoid overflow
            if(mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        //Same to end * end >x. Use divide to avoid overflow
        if(end <= x / end) {
            return end;
        }
        return start;
    }
