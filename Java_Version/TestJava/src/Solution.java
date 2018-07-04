public class Solution {
    public void reOrderArray(int [] array) {

        if (array == null || array.length == 0) {
            return;
        }

        methodOne(array);
    }

    private void methodOne(int[] array) {

        int oddNumbersCount = 0;

        for (int i = 0; i < array.length; i++) {
            if ( array[i] % 2 == 1 ) {
                oddNumbersCount++;
            }
        }

        int[] newArray = new int[array.length];

        int oddPointer = 0;
        int evenPointer = oddNumbersCount;
        for (int i = 0; i < array.length; i++) {
            if ( array[i] % 2 == 1 ) {
                newArray[oddPointer] = array[i];
                oddPointer++;
            } else {
                newArray[evenPointer] = array[i];
                evenPointer++;
            }
        }

        System.arraycopy(newArray,0,array,0,array.length);
    }
}