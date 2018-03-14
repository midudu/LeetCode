/*Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

  You may assume the integer do not contain any leading zero, except the number 0 itself.

  The digits are stored such that the most significant digit is at the head of the list.


 
* 
* 思想：

* (1) 这道题比较简单，注意进位的问题

* (2) 下面的代码比较巧妙，因为特殊情况是类似于9999这样的情况，那么只需要 new int[] 一个数组，数组的各位已经是0了，只需要第一位变成1就可以； 如果没有进位的话，那么循环可以早早结束

------

    
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {
            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newRes = new int[digits.length + 1];
        newRes[0] = 1;
        return newRes;
    }
