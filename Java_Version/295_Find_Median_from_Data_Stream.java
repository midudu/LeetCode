/*
  Median is the middle value in an ordered integer list. If the size of the
list is even, there is no middle value. So the median is the mean of the two
middle value.

For example,
        [2,3,4], the median is 3

        [2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

  void addNum(int num) - Add a integer number from the data stream to the data
structure.
  double findMedian() - Return the median of all elements so far.


Example:

        addNum(1)
        addNum(2)
        findMedian() -> 1.5
        addNum(3)
        findMedian() -> 2

Follow up:

  If all integer numbers from the stream are between 0 and 100, how would you
optimize it?
  If 99% of all integer numbers from the stream are between 0 and 100, how
would you optimize it?

*/


import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

class MedianFinder {

    public static void main(String[] args) {

        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }

    private PriorityQueue<Integer> largeNumbers = new PriorityQueue<>();
    private PriorityQueue<Integer> smallNumbers = new PriorityQueue<>(
            Collections.reverseOrder());

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {

        largeNumbers.offer(num);
        smallNumbers.offer(largeNumbers.poll());

        if (smallNumbers.size() - largeNumbers.size() > 1) {
            Integer peek = smallNumbers.poll();
            largeNumbers.offer(peek);
        }
    }

    public double findMedian() {

        if (largeNumbers.size() != smallNumbers.size()) {
            return (double) smallNumbers.peek();
        } else {
            return (largeNumbers.peek() + smallNumbers.peek()) / 2.0;
        }
    }
}
