/* 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。 */

public class Solution {
    public String replaceSpace(StringBuffer str) {
    	
        StringBuffer result = new StringBuffer();
        int startIndex = 0;
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                result.append(str.subSequence(startIndex, i));
                result.append("%20");
                startIndex = i + 1;
            }
        }
        
        result.append(str.subSequence(startIndex, str.length()));
        
        return result.toString();
    }
}