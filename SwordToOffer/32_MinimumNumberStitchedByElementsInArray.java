/* 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。 */

import java.util.Arrays;
import java.util.Comparator;

class NewComparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {

        String a = o1.toString() + o2.toString();
        String b = o2.toString() + o1.toString();

        return a.compareTo(b);
    }
}

public class Solution {
    public String PrintMinNumber(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return "";
        }

        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i];
        }
        Arrays.sort(nums, new NewComparator());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            result.append(nums[i].intValue());
        }

        return result.toString();
    }
}