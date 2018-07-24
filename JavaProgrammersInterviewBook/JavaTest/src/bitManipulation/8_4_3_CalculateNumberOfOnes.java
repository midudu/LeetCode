package bitManipulation;

class CalculateNumberOfOnes {

    public static int calculateNumberOfOnes(int number) {

        int tempResult;
        int onesCount = 0;
        while (number != 0) {

            tempResult = number & 1;
            if (tempResult != 0) {
                onesCount++;
            }
            number = number >>> 1;
        }

        return onesCount;
    }
}