/*
Compare two version numbers version1 and version2.
        If version1 > version2 return 1; if version1 < version2 return -1;
        otherwise return 0.

You may assume that the version strings are non-empty
and contain only digits and the . character.

The . character does not represent a decimal point and
is used to separate number sequences.

For instance, 2.5 is not "two and a half" or "half way to version three",
it is the fifth second-level revision of the second first-level revision.

        Example 1:

        Input: version1 = "0.1", version2 = "1.1"
        Output: -1
        Example 2:

        Input: version1 = "1.0.1", version2 = "1"
        Output: 1
        Example 3:

        Input: version1 = "7.5.2.4", version2 = "7.5.3"
        Output: -1*/

class Solution {

    public int compareVersion(String version1, String version2) {

        int lastIndex1 = -1, lastIndex2 = -1;

        while (true) {

            int index = lastIndex1 + 1;
            while (index < version1.length()
                    && version1.charAt(index) != '.') {
                index++;
            }

            String currentSubVersion
                    = version1.substring(lastIndex1 + 1, index);
            int num1 = (currentSubVersion.isEmpty() ? 0 :
                    Integer.valueOf(currentSubVersion));
            lastIndex1 = index;

            index = lastIndex2 + 1;
            while (index < version2.length()
                    && version2.charAt(index) != '.') {
                index++;
            }

            currentSubVersion
                    = version2.substring(lastIndex2 + 1, index);
            int num2 = (currentSubVersion.isEmpty() ? 0 :
                    Integer.valueOf(currentSubVersion));
            lastIndex2 = index;

            if (num1 != num2) {
                return Integer.compare(num1, num2);
            }

            if (lastIndex1 == version1.length() || lastIndex2 == version2.length()) {
                break;
            }
        }

        if (lastIndex1 == version1.length() && lastIndex2 == version2.length()) {
            return 0;
        }

        if (lastIndex1 != version1.length()) {
            return isLeftPartZero(version1, lastIndex1) ? 0 : 1;

        } else {
            return isLeftPartZero(version2, lastIndex2) ? 0 : -1;
        }
    }

    private boolean isLeftPartZero(String version, int lastIndex) {

        for (int index = lastIndex + 1; index < version.length(); index++) {

            if (version.charAt(index) >= '1' && version.charAt(index) <= '9') {
                return false;
            }
        }

        return true;
    }
}