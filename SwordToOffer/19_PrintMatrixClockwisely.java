/* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10. */

import java.util.ArrayList;
public class Solution {
    
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       
       if (matrix == null 
           || matrix.length == 0 
           || matrix[0].length == 0) {
           
           return result;
       }
       
       printMatrixHelper(matrix, 0, matrix.length - 1,
                                  0, matrix[0].length - 1);
        
       return result;
    }
    
    private void printMatrixHelper(int[][] matrix, 
                                  int startRow, int endRow,
                                  int startCol, int endCol) {
        
        if (!(startRow <= endRow && startCol <= endCol)) {
            return;
        }
        
        for (int col = startCol; col <= endCol; col++) {
            result.add(matrix[startRow][col]);
        }
        
        for (int row = startRow + 1; row <= endRow; row++) {
            result.add(matrix[row][endCol]);
        }
        
        if ( endRow != startRow) {
            for (int col = endCol - 1; col >= startCol; col-- ){
                result.add(matrix[endRow][col]);
            }
        }
        
        if ( endCol != startCol ) {
            for (int row = endRow - 1; row > startRow; row--) {
                result.add(matrix[row][startCol]);
            }
        }
        
        printMatrixHelper(matrix, startRow + 1, endRow - 1,
                                  startCol + 1, endCol - 1);
    }
}