/*Given a column title as appear in an Excel sheet, return its corresponding column number.

        For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28*/



 
* 
* 思想：

* (1) 比较简单，从后向前逐位读字符串的每一位，用一个变量用于记录 倍数，逐位求和相加，注意编号从1开始的问题

-------

    public int titleToNumber(String s) {

        int result = 0;
        int sLength = s.length();
        int scale = 1;
        for (int i = sLength - 1; i >= 0; i--) {

            result += scale * (s.charAt(i) - 'A' + 1);
            scale *= 26;
        }

        return result;
    }