public class Solution {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

        if (rows <= 0 || cols <= 0 || matrix == null || matrix.length == 0
                || str == null || str.length == 0 || rows * cols != matrix.length) {
            return false;
        }

        char[][] newMatrix = new char[rows][cols];
        convertOneDimensionMatrixToTwoDimensions(matrix, newMatrix);

        int strIndex = 0;

        int[][] hasVisited = new int[rows][cols];

        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {

                if (newMatrix[row][col] == str[0]) {

                    if (hasPathHelper(newMatrix, row, col, str,
                            1, hasVisited)) {
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

        for (int i = 0; i < oneDimensionMatrix.length; i++) {

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

        if (currentIndex >= str.length) {
            return true;
        }

        hasVisited[startRow][startCol] = 1;

        if (startRow - 1 >= 0
                && hasVisited[startRow - 1][startCol] == 0
                && matrix[startRow - 1][startCol] == str[currentIndex]) {

            if (hasPathHelper(matrix, startRow - 1, startCol, str,
                    currentIndex + 1, hasVisited)) {

                hasVisited[startRow][startCol] = 0;
                return true;
            }
        }

        if (startRow + 1 <= matrix.length - 1
                && hasVisited[startRow + 1][startCol] == 0
                && matrix[startRow + 1][startCol] == str[currentIndex]) {

            if (hasPathHelper(matrix, startRow + 1, startCol, str,
                    currentIndex + 1, hasVisited)) {

                hasVisited[startRow][startCol] = 0;
                return true;
            }
        }


        if (startCol - 1 >= 0
                && hasVisited[startRow][startCol - 1] == 0
                && matrix[startRow][startCol - 1] == str[currentIndex]) {

            if (hasPathHelper(matrix, startRow, startCol - 1, str,
                    currentIndex + 1, hasVisited)) {

                hasVisited[startRow][startCol] = 0;
                return true;
            }
        }


        if (startCol + 1 <= matrix[0].length - 1
                && hasVisited[startRow][startCol + 1] == 0
                && matrix[startRow][startCol + 1] == str[currentIndex]) {

            if (hasPathHelper(matrix, startRow, startCol + 1, str,
                    currentIndex + 1, hasVisited)) {

                hasVisited[startRow][startCol] = 0;
                return true;
            }
        }

        hasVisited[startRow][startCol] = 0;
        return false;
    }

    public static void main(String[] args) {

        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        int row = 3;
        int col = 4;

        char[] str = {'a', 'b', 'c', 'b'};

        boolean result = new Solution().hasPath(matrix,
                row, col, str);

        System.out.println();
    }
}
