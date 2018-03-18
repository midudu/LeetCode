/*Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
Example 1:
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
Example 2:
Input: 1
Output: 0
Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.*/

 
* 
* 思想：

* (1) 首先调用Integer类的highestOneBit函数求最高位，然后，左移一位后减1可以得到有效位都是1的数，与源数字求异或即可

----
    

    public int findComplement(int num) {

        int exclusiveOR = Integer.highestOneBit(num);
        exclusiveOR = (exclusiveOR << 1) - 1;

        return (num^exclusiveOR);
    }
