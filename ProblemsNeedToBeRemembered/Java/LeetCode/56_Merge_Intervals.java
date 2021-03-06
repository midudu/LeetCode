/*
Given a collection of intervals, merge all overlapping intervals.

        Example 1:

        Input: [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

        Example 2:

        Input: [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considerred overlapping.*/


import java.util.*;

class Interval {

    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

// Method 1: Comparator Used
/*
class Solution {

    class IntervalComparator implements Comparator<Interval> {

        public int compare(Interval o1, Interval o2) {

            if (o1.start != o2.start) {
                return Integer.compare(o1.start, o2.start);
            } else {
                return Integer.compare(o1.end, o2.end);
            }
        }
    }
	

    public List<Interval> merge(List<Interval> intervals) {

        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }

        IntervalComparator intervalComparator = new IntervalComparator();

        intervals.sort(intervalComparator);

        List<Interval> result = new ArrayList<>(intervals.size());

        for (int i = 0; i < intervals.size(); i++) {

            if (result.isEmpty()) {
                result.add(intervals.get(i));
            }

            Interval currentInterval = intervals.get(i);
            Interval lastInterval = result.get(result.size() - 1);
            if (currentInterval.start <= lastInterval.end) {
                lastInterval.end = Math.max(currentInterval.end, lastInterval.end);
            } else {
                result.add(currentInterval);
            }
        }

        return result;
    }
}*/

// Method 2: Comparator Not Used
class Solution {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.size() == 0) {
            return result;
        }

        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++) {

            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startIndex = 0;

        for (int i = 1; i < intervals.size(); i++) {

            if (start[i] > end[i - 1]) {
                result.add(new Interval(start[startIndex], end[i - 1]));
                startIndex = i;
            }
        }

        result.add(new Interval(start[startIndex], end[intervals.size() - 1]));

        return result;
    }
}