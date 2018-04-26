/*Given a positive integer, return its corresponding column title as appear in an Excel sheet.

  For example:

   1 -> A

   2 -> B

   3 -> C

   ...

  26 -> Z

  27 -> AA

  28 -> AB*/




 
* 
* 思想：

* (1) 首先要注意编号从 1开始，所以要先-1再处理

* (2) 一种比较巧妙的方法是 运用递归函数输出， 注意递归的终止条件

-------


    public String convertToTitle(int n) {

        if (n == 0) {
            return "";
        } else {
            n--;
            return convertToTitle(n / 26) + (char) ('A' + n % 26);
        }
    }