import java.util.HashMap;
import java.util.Map;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {

        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {

            table.put(i, table.getOrDefault(i, 0) + 1);
        }

        boolean findFirstNumberFlag = false;
        for (Map.Entry<Integer, Integer> entry : table.entrySet()) {

            if (entry.getValue() == 1) {
                if (findFirstNumberFlag == false) {
                    findFirstNumberFlag = true;
                    num1[0] = entry.getKey();
                } else {
                    num2[0] = entry.getKey();
                    return;
                }
            }
        }
    }
}