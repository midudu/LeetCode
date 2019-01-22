/*
According to the Wikipedia's article:
"The Game of Life, also known simply as Life,
is a cellular automaton devised by the British mathematician
John Horton Conway in 1970."

Given a board with m by n cells,
each cell has an initial state live (1) or dead (0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

        Any live cell with fewer than two live neighbors dies, as if caused by under-population.
        Any live cell with two or three live neighbors lives on to the next generation.
        Any live cell with more than three live neighbors dies, as if by over-population..
        Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
        Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

        Example:

        Input:
        [
        [0,1,0],
        [0,0,1],
        [1,1,1],
        [0,0,0]
        ]
        Output:
        [
        [0,0,0],
        [1,0,1],
        [0,1,1],
        [0,1,0]
        ]
        Follow up:

        Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
        In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?*/


/*class Solution {

    private int[][] positions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    public void gameOfLife(int[][] board) {

        if (board == null
                || board.length == 0 || board[0].length == 0) {
            return;
        }

        // system.arraycopy or Arrays.copyOf is shadow-copy, so use loop instead
        int[][] boardCopy = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                boardCopy[row][col] = board[row][col];
            }
        }

        for (int row = 0; row < boardCopy.length; row++) {
            for (int col = 0; col < boardCopy[row].length; col++) {

                int count = countOfOnes(boardCopy, row, col);

                if (boardCopy[row][col] == 0) {
                    if (count == 3) {
                        board[row][col] = 1;
                    }
                } else {
                    if (count != 2 && count != 3) {
                        board[row][col] = 0;
                    }
                }
            }
        }
    }

    private int countOfOnes(int[][] board, int row, int col) {

        int count = 0;

        for (int i = 0; i < positions.length; i++) {

            int currentRow = row + positions[i][0];
            if (currentRow < 0 || currentRow >= board.length) {
                continue;
            }

            int currentCol = col + positions[i][1];
            if (currentCol < 0 || currentCol >= board[0].length) {
                continue;
            }

            if (board[currentRow][currentCol] == 1) {
                count++;
            }
        }

        return count;
    }
}*/

class Solution {
    public void gameOfLife(int[][] board) {
        //there are four type of state
        //board[]==0 cell is die and will die
        //board[]==1 cell is live and will live
        //board[]==2  cell is live and will die
        //board[]==3 cell is die and will live
        final int m=board.length;
        final int n=board[0].length;
        //index clock wise,from upper left.
        final int[] dx={-1,-1,-1,0,1,1,1,0};
        final int[] dy={-1,0,1,1,1,0,-1,-1};
        //encode
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x,y;
                int life=0;
                for(int k=0;k<8;k++){
                    x=i+dx[k];
                    y=j+dy[k];
                    if(x>-1&&x<m&&y>-1&&y<n&&(board[x][y]==1 || board[x][y]==2)){
                        life++;
                    }
                }
                if(board[i][j]==1 &&(life<2 || life>3)){
                    board[i][j]=2;
                }
                if(board[i][j]==0 && life==3){
                    board[i][j]=3;
                }
            }
        }
        //decode
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]%=2;
            }
        }
    }
}