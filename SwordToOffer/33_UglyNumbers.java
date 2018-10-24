/* 
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。 */

public class Solution {
    public int GetUglyNumber_Solution(int index) {

        if (index < 1) {
            return 0;
        }

        int[] result = new int[index];
        result[0] = 1;
        int currentIndex = 1;

        int twoPointer = 0;
        int threePointer = 0;
        int fivePointer = 0;

        while (currentIndex < index) {

            int minValue = Math.min(
                    Math.min(result[twoPointer] * 2, result[threePointer] * 3),
                    result[fivePointer] * 5);
            
            result[currentIndex] = minValue;

            if (minValue == result[twoPointer] * 2) {
                twoPointer++;
            }
            if (minValue == result[threePointer] * 3) {
                threePointer++;
            }
            if (minValue == result[fivePointer] * 5) {
                fivePointer++;
            }
            currentIndex++;
        }

        return result[index - 1];
    }
}