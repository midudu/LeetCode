/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given numRows, generate the first numRows of Pascal's triangle.

  For example, given numRows = 5,
  
  Return

        [
        [1],
        [1,1],
        [1,2,1],
        [1,3,3,1],
        [1,4,6,4,1]
        ]*/

 
* 
* 思想：

* (1) 首先排除 输入为0,1,2的 特殊情况，为了防止溢出，采取加法的方式，下行的数据由上行加和得出

-------


    public List<List<Integer>> generate(int numRows) {

        if (numRows <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<Integer>(1);
        firstRow.add(1);
        result.add(firstRow);
        if (numRows == 1) {
            return result;
        }

        List<Integer> secondRow = new ArrayList<Integer>(2);
        secondRow.add(1);
        secondRow.add(1);
        result.add(secondRow);
        if (numRows == 2) {
            return result;
        }

        for (int row = 3; row <= numRows; row++) {
            List<Integer> tempRow = new ArrayList<Integer>(row);
            tempRow.add(1);
            int size = result.get(row - 2).size();
            for (int col = 1; col < size; col++) {
                tempRow.add(result.get(row - 2).get(col) + result.get(row - 2).get(col - 1));
            }
            tempRow.add(1);
            result.add(tempRow);
        }

        return result;
    }