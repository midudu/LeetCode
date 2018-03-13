/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/


 
* 
* 思想：

* (1) 思想是用栈的思想：把各种左括号压入栈，当各种右括号来临时，如果栈为空栈或者栈顶不匹配则返回false

* (2) 先把 String 转成 char[]

* (3) 为了加快速度，可以用数组模拟栈的功能

----
    
    
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[head++] = c;
            } else if (c == '[') {
                stack[head++] = c;
            } else if (c == '{') {
                stack[head++] = c;
            } else if (c == ')') {
                if (head == 0) return false;
                if (stack[--head] != '(') return false;
            } else if (c == ']') {
                if (head == 0) return false;
                if (stack[--head] != '[') return false;
            } else if (c == '}') {
                if (head == 0) return false;
                if (stack[--head] != '{') return false;
            }
        }
        return head == 0;
    }
