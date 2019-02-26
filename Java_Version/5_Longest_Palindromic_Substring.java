class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] sChar = s.toCharArray();

        // answerInformation[0]: the start index of the answer
        // answerInformation[0]: the length of the answer (for comparison in
        //                       every loop)
        int[] answerInformation = new int[2];

        for (int middleIndex = 0; middleIndex < s.length(); middleIndex++) {
            
            if ( middleIndex != 0 && sChar[middleIndex] == sChar[middleIndex - 1] ) {
                continue;
            }
            
            checkCurrentSituation(sChar, middleIndex, answerInformation);
        }

        return s.substring(answerInformation[0],
                answerInformation[0] + answerInformation[1]);
    }

    private void checkCurrentSituation(
            char[] s, int currentMiddleIndex, int[] answerInformation) {
                
        int leftIndex = currentMiddleIndex - 1;
        while (currentMiddleIndex < s.length - 1
                && s[currentMiddleIndex] == s[currentMiddleIndex + 1]) {
            currentMiddleIndex++;
        }

        int rightIndex = currentMiddleIndex + 1;

        while (leftIndex >= 0 && rightIndex < s.length
                && s[leftIndex] == s[rightIndex]) {
            leftIndex--;
            rightIndex++;
        }

        int currentLength = rightIndex - leftIndex - 1;
        if (currentLength > answerInformation[1]) {
            answerInformation[0] = leftIndex + 1;
            answerInformation[1] = currentLength;
        }
    }
}