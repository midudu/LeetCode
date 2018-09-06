/* 
题目描述

给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。

例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 

针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： 

{[2,3,4],2,6,2,5,1}， 
{2,[3,4,2],6,2,5,1}， 
{2,3,[4,2,6],2,5,1}， 
{2,3,4,[2,6,2],5,1}， 
{2,3,4,2,[6,2,5],1}， 
{2,3,4,2,6,[2,5,1]}。 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private Queue<Integer> maxNumberQueue = new LinkedList<>();
    private Queue<Integer> numberQueue = new LinkedList<>();

    private ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        if ( num == null || num.length == 0 || size <= 0
           || size > num.length ) {
            return result;
        }

        initStack(num, size);

        maxInWindowsHelper(num, size);

        return result;
    }

    private void initStack(int[] num, int slidingWindowSize) {

        int size = (slidingWindowSize <= num.length ? slidingWindowSize : num.length);

        for (int i = 0; i < size - 1; i++) {

            offer(num[i]);
        }
    }

    private void maxInWindowsHelper(int[] num, int slidingWindowSize) {

        int size = (slidingWindowSize <= num.length ? slidingWindowSize : num.length);

        for (int i = size - 1; i < num.length; i++) {

            offer(num[i]);

            result.add(maxNumberQueue.peek());

            poll();
        }
    }

    private void offer(int value) {

        numberQueue.offer(value);

        if (maxNumberQueue.isEmpty()) {
            maxNumberQueue.offer(value);
        } else {

            Queue<Integer> temp = new LinkedList<>();

            while (!maxNumberQueue.isEmpty()) {
                int currentValue = maxNumberQueue.poll();
                if ( currentValue >= value) {
                    temp.offer(currentValue);
                }
            }

            while (!temp.isEmpty()) {
                int currentValue = temp.poll();
                maxNumberQueue.offer(currentValue);
            }
            maxNumberQueue.offer(value);
        }
    }

    private void poll() {

        int value = numberQueue.poll();
        if ( value == maxNumberQueue.peek() ) {
            maxNumberQueue.poll();
        }
    }
}