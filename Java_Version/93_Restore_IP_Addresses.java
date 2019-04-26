/*
  Given a string containing only digits, restore it by returning all possible 
valid IP address combinations.

Example:

  Input: "25525511135"
  Output: ["255.255.11.135", "255.255.111.35"]
*/


import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> restoreIpAddresses(String s) {

        if (s == null || s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();

        List<String> existingResult = new ArrayList<>();

        restoreIpAddressHelper(s, 0, existingResult, result);

        return result;
    }

    private void restoreIpAddressHelper(
            String s, int currentIndex,
            List<String> existingResult, List<String> result) {

        if (existingResult.size() == 4) {

            if (currentIndex >= s.length()) {

                StringBuilder currentIp = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    currentIp.append(existingResult.get(i));
                    currentIp.append('.');
                }
                currentIp.append(existingResult.get(3));

                result.add(currentIp.toString());
            }

            return;
        }

        if (currentIndex >= s.length()) {
            return;
        }

        // 1 bit
        existingResult.add(s.substring(currentIndex, currentIndex + 1));
        restoreIpAddressHelper(s, currentIndex + 1, existingResult, result);
        existingResult.remove(existingResult.size() - 1);

        // 2 bit
        if (currentIndex <= s.length() - 2) {
            String twoBitIp = s.substring(currentIndex, currentIndex + 2);
            if (Integer.valueOf(twoBitIp) >= 10
                    && Integer.valueOf(twoBitIp) <= 99) {

                existingResult.add(twoBitIp);
                restoreIpAddressHelper(s, currentIndex + 2,
                        existingResult, result);
                existingResult.remove(existingResult.size() - 1);
            }
        }

        // 3 bit
        if (currentIndex <= s.length() - 3) {

            String threeBitIp = s.substring(currentIndex, currentIndex + 3);
            if (Integer.valueOf(threeBitIp) >= 100
                    && Integer.valueOf(threeBitIp) <= 255) {

                existingResult.add(threeBitIp);
                restoreIpAddressHelper(s, currentIndex + 3,
                        existingResult, result);
                existingResult.remove(existingResult.size() - 1);
            }
        }
    }
}