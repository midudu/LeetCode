/* 
题目描述

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。

路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。

如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 

例如 a b c e 
     s f c s 
	 a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
	 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。 */
	 

public class Solution {
	
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        
		if ( rows <= 0 || cols <= 0 || matrix == null || matrix.length == 0
		|| str == null || str.length == 0 || rows * cols != matrix.length ) {
			return false;
		}
		
		char[][] newMatrix = new char[rows][cols];
		convertOneDimensionMatrixToTwoDimensions(matrix, newMatrix);
		
		int strIndex = 0;
		
		int[][] hasVisited = new char[rows][cols];
		
		for ( int row = 0; row < newMatrix.length; row++ ) {
			for ( int col = 0; col < newMatrix[row].length; col++ ) {
				
				if ( newMatrix[row][col] == str[0] ) {
					
					if ( hasPathHelper(newMatrix, row, col, str, 1, hasVisited) ) {
						return true;
					}
				}
			}
		}
		
		return false;
    }
	
	private void convertOneDimensionMatrixToTwoDimensions(
	                    char[] oneDimensionMatrix, char[][] twoDimensionMatrix) {
		
		int rowIndex = 0;
		int colIndex = 0;
		
		for ( int i = 0; i < oneDimensionMatrix.length; i++ ) {
			
			twoDimensionMatrix[rowIndex][colIndex] = oneDimensionMatrix[i];
			
			colIndex++;
			if (colIndex == twoDimensionMatrix[0].length) {
				colIndex = 0;
				rowIndex++;
			}
		}
	}
	
	private boolean hasPathHelper(char[][] matrix, int startRow, int startCol, 
	                              char[] str, int currentIndex, 
								  int[][] hasVisited) {
									  
		if ( currentIndex >= str.length ) {
			return true;
		}
		
		hasVisited[startRow][startCol] = 1;
		
		if ( startRow - 1 >= 0 
		&& hasVisited[startRow-1][startCol] == 0 
		&& matrix[startRow-1][startCol] == str[currentIndex] ) {
			
			if (hasPathHelper(matrix, startRow-1, startCol, str, currentIndex + 1, hasVisited)) {
									  
				hasVisited[startRow][startCol] = 0;
				return true;
			}
		}
		
		if ( startRow + 1 <= matrix.length - 1
		&& hasVisited[startRow+1][startCol] == 0 
		&& matrix[startRow+1][startCol] == str[currentIndex] ) {
			
			if (hasPathHelper(matrix, startRow+1, startCol, str, currentIndex + 1, hasVisited)) {
									  
				hasVisited[startRow][startCol] = 0;
				return true;
			}
		}
		
		
		if ( startCol - 1 >= 0 
		&& hasVisited[startRow][startCol-1] == 0 
		&& matrix[startRow][startCol-1] == str[currentIndex] ) {
			
			if (hasPathHelper(matrix, startRow, startCol-1, str, currentIndex + 1, hasVisited)) {
									  
				hasVisited[startRow][startCol] = 0;
				return true;
			}
		}
		
		
		if ( startCol + 1 <= matrix[0].length - 1
		&& hasVisited[startRow][startCol+1] == 0 
		&& matrix[startRow][startCol+1] == str[currentIndex] ) {
			
			if (hasPathHelper(matrix, startRow, startCol+1, str, currentIndex + 1, hasVisited)) {
									  
				hasVisited[startRow][startCol] = 0;
				return true;
			}
		}
		
		hasVisited[startRow][startCol] = 0;
		return false;
	}
}
