/* 题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），
现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！ */

public class Solution {
    public String LeftRotateString(String str, int n) {

        if (str == null || str.length() == 0) {
            return str;
        }

        if (n < 0) {
            int k = (0 - n) / str.length();
            n += str.length() * (k + 1);
        }

        n = n % str.length();

        char[] strChar = str.toCharArray();
        char[] temp = new char[n];
        
        System.arraycopy(strChar, 0, temp, 0, n);
        System.arraycopy(strChar, n, strChar, 0, str.length() - n);
        System.arraycopy(temp, 0, strChar, str.length() - n, n);

        return new String(strChar);
  }
}