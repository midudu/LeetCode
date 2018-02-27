* Given an integer, convert it to a roman numeral.

  Input is guaranteed to be within the range from 1 to 3999.


 
* 
* 思想：

* (1) 对阿拉伯数字进行编码，提取出个十百千位


* (2) 提前找到阿拉伯数字和对应罗马字符串的对应关系

-----
    String[] thousand = {"", "M", "MM", "MMM" };    //0, 1000, 2000, 3000
    String[] hundred = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] ten = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] one = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

* (3) 直接进行字符串拼接

* (4) 更优的方法是缩短编码数量，例如 700 是一个用不上的编码

---
    private static int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] strings = new String[]{"M", "CM", "D", "CD", "C", 
                                                   "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
