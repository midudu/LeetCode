/* 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。 */

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    
    private ArrayList<Integer> result = new ArrayList<Integer>();
    
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        
        if (array == null || array.length < 2) {
            return result;
        }
        
        HashSet<Integer> existingNumbers = new HashSet<Integer>();
        for (int i = 0; i < array.length; i++) {
            if (existingNumbers.contains(sum - array[i])) {
                if (result.isEmpty()) {
                    result.add(sum-array[i]);
                    result.add(array[i]);
                } else {
                    int product1 = result.get(0) * result.get(1);
                    int product2 = (sum - array[i]) * array[i];
                    if (product2 < product1) {
                        result.set(0, sum - array[i]);
                        result.set(1, array[i]);
                    }
                }
            }
            existingNumbers.add(array[i]);
        }
                
        return result;
    }
}