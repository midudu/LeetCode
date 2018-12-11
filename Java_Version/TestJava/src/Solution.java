
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,4,5);

        List<Integer> integerList = Collections.synchronizedList(list);
        integerList.add(3);
    }
}