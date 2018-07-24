package string;

/* 假设字符串的所有字符都不重复，如何输出字符串的所有组合？例如，输入"abc",输出a,b,c,ab,ac,bc,,abc 7种组合 */

class PrintAllCombinationsOfAString {

    public String[] printAllCombinationsOfAString(String inputString) {

        if (inputString == null || inputString.length() == 0) {
            return null;
        }

        int combinationsCount = Math.round((float) Math.pow(2, inputString.length()));
        int standard = 1 << inputString.length();
        String[] result = new String[combinationsCount - 1];

        for (int i = 1; i < combinationsCount; i++) {

            result[i - 1] = generateNewString(i, standard, inputString);
        }

        return result;
    }

    private String generateNewString(int currentNumber, int standard, String inputString) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            standard = standard >>> 1;
            if ((currentNumber & standard) != 0) {
                result.append(inputString.charAt(i));
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {

        String input = "abc";
        String[] result
                = new PrintAllCombinationsOfAString().printAllCombinationsOfAString(input);

        System.out.println("haha");
    }
}