/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

        Each LED represents a zero or one, with the least significant bit on the right.


        For example, the above binary watch reads "3:25".

        Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

        Example:

        Input: n = 1
        Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
        Note:
        The order of output does not matter.
        The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
        The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".*/


import javax.print.DocFlavor;
import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test {
    public static void main(String[] args) {

        int input = 999999999;

        new Solution().findNthDigit(input);
    }
}


class Solution {

    private List<String> result = new LinkedList<>();

    public List<String> readBinaryWatch(int num) {

        for (int hourNumbers = 0; hourNumbers <= num; hourNumbers++) {
            String[] hourString = processWithHour(hourNumbers);
            String[] minuteString = processWithMinute(num - hourNumbers);

            if (hourString != null && minuteString != null) {
                connectString(hourString, minuteString);
            }
        }

        return result;
    }

    private String[] processWithHour(int num) {

        switch (num) {

            case 0: {
                return new String[]{"0"};
            }
            case 1: {
                return new String[]{"1", "2", "4", "8"};
            }
            case 2: {
                return new String[]{"3", "5", "9", "6", "10"};
            }
            case 3: {
                return new String[]{"7", "11"};
            }
            case 4: {
                return null;
            }
            default: {
                return null;
            }
        }
    }

    private String[] processWithMinute(int num) {

        if (num == 6) {
            return null;
        }
        if (num == 0) {
            return new String[]{"00"};
        }

        if (num == 1) {
            return new String[]{"01", "02", "04", "08", "16", "32"};
        }

        if (num == 2) {
            return new String[]{"03", "05", "09", "17", "33",
                    "06", "10", "18", "34",
                    "12", "20", "36",
                    "24", "40", "48"};
        }

        if (num == 3) {
            return new String[]{"07", "11", "19", "35",
                    "13", "21", "37",
                    "25", "41", "49",
                    "14", "22", "38",
                    "26", "42", "50", "52",
                    "28", "44", "56"};
        }
        if (num == 4) {
            return new String[]{"58", "54", "46", "30",
                    "57", "53", "45", "29",
                    "51", "43", "27",
                    "39", "23", "15"};
        }
        if (num == 5) {
            return new String[]{"59", "55", "47", "31"};
        }

        return null;
    }

    private void connectString(String[] hourString, String[] minuteString) {

        for (int i = 0; i < hourString.length; i++) {
            for (int j = 0; j < minuteString.length; j++) {

                result.add(hourString[i] + ":" + minuteString[j]);
            }
        }
    }
}

["0:60",
        "0:58",
        "0:54",""0:57",

        "1:07","1:11","1:19","1:35","1:13","1:21","1:37","1:25","1:41","1:49","1:14","1:22","1:38","1:26","1:42","1:50","1:52","1:28","1:44","1:56","2:07","2:11","2:19","2:35","2:13","2:21","2:37","2:25","2:41","2:49","2:14","2:22","2:38","2:26","2:42","2:50","2:52","2:28","2:44","2:56","4:07","4:11","4:19","4:35","4:13","4:21","4:37","4:25","4:41","4:49","4:14","4:22","4:38","4:26","4:42","4:50","4:52","4:28","4:44","4:56","8:07","8:11","8:19","8:35","8:13","8:21","8:37","8:25","8:41","8:49","8:14","8:22","8:38","8:26","8:42","8:50","8:52","8:28","8:44","8:56","3:03","3:05","3:09","3:17","3:33","3:06","3:10","3:18","3:34","3:12","3:20","3:36","3:24","3:40","3:48","5:03","5:05","5:09","5:17","5:33","5:06","5:10","5:18","5:34","5:12","5:20","5:36","5:24","5:40","5:48","9:03","9:05","9:09","9:17","9:33","9:06","9:10","9:18","9:34","9:12","9:20","9:36","9:24","9:40","9:48","6:03","6:05","6:09","6:17","6:33","6:06","6:10","6:18","6:34","6:12","6:20","6:36","6:24","6:40","6:48","10:03","10:05","10:09","10:17","10:33","10:06","10:10","10:18","10:34","10:12","10:20","10:36","10:24","10:40","10:48","7:01","7:02","7:04","7:08","7:16","7:32","11:01","11:02","11:04","11:08","11:16","11:32"]

"0:54","0:57","0:58",

        "1:07","1:11","1:13","1:14","1:19","1:21","1:22","1:25","1:26","1:28","1:35","1:37","1:38","1:41","1:42","1:44","1:49","1:50","1:52","1:56","2:07","2:11","2:13","2:14","2:19","2:21","2:22","2:25","2:26","2:28","2:35","2:37","2:38","2:41","2:42","2:44","2:49","2:50","2:52","2:56","3:03","3:05","3:06","3:09","3:10","3:12","3:17","3:18","3:20","3:24","3:33","3:34","3:36","3:40","3:48","4:07","4:11","4:13","4:14","4:19","4:21","4:22","4:25","4:26","4:28","4:35","4:37","4:38","4:41","4:42","4:44","4:49","4:50","4:52","4:56","5:03","5:05","5:06","5:09","5:10","5:12","5:17","5:18","5:20","5:24","5:33","5:34","5:36","5:40","5:48","6:03","6:05","6:06","6:09","6:10","6:12","6:17","6:18","6:20","6:24","6:33","6:34","6:36","6:40","6:48","7:01","7:02","7:04","7:08","7:16","7:32","8:07","8:11","8:13","8:14","8:19","8:21","8:22","8:25","8:26","8:28","8:35","8:37","8:38","8:41","8:42","8:44","8:49","8:50","8:52","8:56","9:03","9:05","9:06","9:09","9:10","9:12","9:17","9:18","9:20","9:24","9:33","9:34","9:36","9:40","9:48","10:03","10:05","10:06","10:09","10:10","10:12","10:17","10:18","10:20","10:24","10:33","10:34","10:36","10:40","10:48","11:01","11:02","11:04","11:08","11:16","11:32"]