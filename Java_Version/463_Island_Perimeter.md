/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:45 CST 2018*/

/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

        
Example:

 [[0,1,0,0],

 [1,1,1,0],

 [0,1,0,0],

 [1,1,0,0]]


 Answer: 16

  Explanation: The perimeter is the 16 yellow stripes in the image below:


 
* 
* 思想：

* (1) 常规思想是遍历二维数组中的每一个元素，判断它们的上下左右各有几个相邻的1，这样的做法是 O(4*n)
*
* (2) 改进方法是 对于每一个元素，只需要判断它们的左侧和上方，这样的做法是O(2*n)

-----


    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int gridCount = 0;
        int leftOrUpRepeatCount = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == 1) {
                    gridCount++;

                    if (row != 0 && grid[row - 1][col] == 1) {
                        leftOrUpRepeatCount++;
                    }
                    if (col != 0 && grid[row][col - 1] == 1) {
                        leftOrUpRepeatCount++;
                    }
                }
            }
        }

        return (gridCount * 4 - leftOrUpRepeatCount * 2);
    }
    