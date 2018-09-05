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
import java.util.Stack;

public class Solution {
	
	Stack<Integer> maxNumberStack = new Stack<Integer>();
	Stack<Integer> numberStack = new Stack<Integer>();
	
	ArrayList<Integer> result = new ArrayList<>();
	
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
		
        
		if ( num == null || num.length == 0 || size <= 0) {
			return result;
		}
		
		initStack(num, size);
		
    }
	
	private void initStack(int[] num, int slidingWindowSize) {
		
		int size = (slidingWindowSize <= num.length ? slidingWindowSize : num.length);
		
		for ( int i = 0; i < size - 1; i++ ) {
			numberStack.push(num[i]);
			if ( maxNumberStack.empty() ) {
				maxNumberStack.push(num[i]);
			} else {
				int maxNum = maxNumberStack.peek();
				if ( num[i] == maxNum ) {
					maxNumberStack.push(num[i]);
				} else if ( num[i] > maxNum ) {
					maxNumberStack.clear();
					maxNumberStack.push(num[i]);
				}
			}
		}
	}
}