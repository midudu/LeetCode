/*Given an integer n, return the number of trailing zeroes in n!.

  Note: Your solution should be in logarithmic time complexity.*/

 
* 
* 思想：

* (1) 0是由 2*5产生的，由于所有组成阶乘的数中5的数量比2少，所以最终0的个数等于所有参与的数中包含5的个数；

* (2) 容易忽略的情况是类似25这样的包含着 2个 5的数字

* (3) 最后的方法十分巧妙：包含5的个数可以通过 int(n/5)求出， 包含25的个数可以通过 int(n/25)求出……，所以可以通过一个递归函数来求

--------

    public int trailingZeroes(int n) {

        if (n == 0) {
            return 0;
        }
        return (n / 5) + trailingZeroes(n / 5);
    }