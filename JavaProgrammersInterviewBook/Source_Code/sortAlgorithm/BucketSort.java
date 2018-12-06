package sortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

class BucketSort {

    public static void bucketSort(int[] nums, int maxValue, int minValue, int bucketNumber) {

        ArrayList<ArrayList<Integer>> bucketsContainer = new ArrayList<>();
        for (int i = 0; i < bucketNumber; i++) {
            ArrayList<Integer> newBucket = new ArrayList<>();
            bucketsContainer.add(newBucket);
        }

        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - minValue) / 10;

            bucketsContainer.get(index).add(nums[i]);
        }

        for (int i = 0; i < bucketsContainer.size(); i++) {
            int[] tempNums = new int[bucketsContainer.get(i).size()];
            for (int j = 0; j < bucketsContainer.get(i).size(); j++) {
                tempNums[j] = bucketsContainer.get(i).get(j);
            }
            QuickSort.quickSort(tempNums);
            System.out.println(Arrays.toString(tempNums));
        }

        System.out.println();
    }


    public static void main(String[] args) {

        int[] score = {63, 90, 72, 85, 96, 80, 70, 61, 77};

        bucketSort(score, 100, 60, 4);   //4个桶 60-70, 70-80, 80-90, 90-100

        System.out.println();
    }
}