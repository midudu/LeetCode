/* 
题目描述

地上有一个m行和n列的方格。

一个机器人从坐标0,0的格子开始移动，
每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 

例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。

但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？ */

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
	
	private int result = 0;
	
	private Queue<Point> queue = new LinkedList<Point>();
	
    public int movingCount(int threshold, int rows, int cols) {
		
		if ( threshold < 0 || rows <= 0 || cols <= 0 ) {
			return 0;
		}
		
		int[][] hasVisited = new int[rows][cols];
        
		queue.offer(new Point(0,0));
		
		while ( !queue.isEmpty() ) {
			
			Point point = queue.poll();
			
			movingCountHelper(threshold, point.row, point.col, hasVisited);
		}
		
		return result;
    }
	
	private void movingCountHelper(int threshold, int currentRow, int currentCol, int[][] hasVisited) {
		
		if ( hasVisited[currentRow][currentCol] == 1 ) {
			return;
		}
		
		result++;
		hasVisited[currentRow][currentCol] = 1;
		
		if ( currentRow - 1 >= 0 && hasVisited[currentRow-1][currentCol] == 0)  {
			
			int sum = calculateSum(currentRow-1, currentCol);
			if ( sum <= threshold ) {
				queue.offer(new Point(currentRow-1, currentCol));
			}
		}
		
		if ( currentRow + 1 <= hasVisited.length - 1 && hasVisited[currentRow+1][currentCol] == 0)  {
			
			int sum = calculateSum(currentRow+1, currentCol);
			if ( sum <= threshold ) {
				queue.offer(new Point(currentRow+1, currentCol));
			}
		}
		
		if ( currentCol - 1 >= 0 && hasVisited[currentRow][currentCol-1] == 0)  {
			
			int sum = calculateSum(currentRow, currentCol-1);
			if ( sum <= threshold ) {
				queue.offer(new Point(currentRow, currentCol-1));
			}
		}
		
		if ( currentCol + 1 <= hasVisited[0].length - 1 && hasVisited[currentRow][currentCol+1] == 0)  {
			
			int sum = calculateSum(currentRow, currentCol+1);
			if ( sum <= threshold ) {
				queue.offer(new Point(currentRow, currentCol+1));
			}
		}
	}
	
	private int calculateSum(int row, int col) {
		
		int sum = 0;
		
		while ( row != 0 ) {
			
			sum += row % 10;
			row = row / 10;
		}
		
		while ( col != 0 ) {
			sum += col % 10;
			col = col / 10;
		}
		
		return sum;
	}
}

class Point {
	
	int row;
	int col;
	
	public Point(int row, int col) {
		
		this.row = row;
		this.col = col;
	}
}