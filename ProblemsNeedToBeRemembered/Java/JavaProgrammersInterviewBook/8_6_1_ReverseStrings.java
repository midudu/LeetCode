package string;

/* 把一个句子中的单词进行反转，例如 "How are you"反转后为 "you are how" */

class ReverseStrings {

    public String reverseStrings(String string) {

        if (string == null || string.length() <= 1) {
            return string;
        }

        String[] singleStrings = string.split(" ");
        for (int i = 0; i < singleStrings.length; i++) {

            singleStrings[i] = this.reverseSingleString(singleStrings[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < singleStrings.length; i++) {
            result.append(singleStrings[i]);

            if (i != singleStrings.length - 1) {
                result.append(" ");
            }
        }

        return this.reverseSingleString(result.toString());
    }


    private String reverseSingleString(String string) {

        StringBuilder stringBuilder = new StringBuilder(string).reverse();

        return stringBuilder.toString();
    }
}