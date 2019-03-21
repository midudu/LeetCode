import java.util.*;

/**
 * ST表
 *
 * 这种数据结构针对的应用场景是数组固定、频繁查询一定范围内数组的最小/最大值。由于查询是频繁的，
 * 所以要考虑使用表来预存储信息。常规的想法是存储所有从i到k范围内的最小值，这样查询的时间复杂度
 * 是O(1),但是建表的时间复杂度是O(n^2)。
 *
 * 那ST表的做法是想办法将建表复杂度从O(n^2)降到O(nlogn)。为了完成这一操作，需要考虑将区间长度
 * 每次二分，这样就会出现logn一项。具体操作是见一个二维表table，其中table[i][j]代表起始位置是i、
 * 查询区间长度为2^j的最小值。这样table表的行数为数组的元素个数，列数为[log2(数组的元素个数)]+1;
 * table表的第一列就是数组本身，接下来每一列的建表过程是动态规划的过程(将区间二分，取两者最小值)：
 * table[i][j] = min(table[i, j/2], table[i+2^(j-1), j/2)，这样建表的时间复杂度下降到了
 * O(nlogn)。查询的过程是把查询[a, b]区间内的最小值，等价转化为求[a, c]和[d, b]之间最小值的
 * 较小量，两段期间可以重叠，但是长度要一致，区间的长度是2 ^ ([log(b-a)])，因此查询的时间复杂度
 * 依然是O(1)
 *
 */
class SparseTable {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(
                10, 3, 2, -1, -2, 9, 7, 1, 4, 8, 11, 6, 5, -4);
        //Collections.shuffle(list);
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        //System.out.println(Arrays.toString(array));
        //System.out.println();

        SparseTable sparseTable = new SparseTable(array);
        //sparseTable.printTable();

        System.out.println("sparseTable.findMinElement(0, 14)  "
                + sparseTable.findMinElement(0, 14));
        System.out.println("sparseTable.findMinElement(0, 14)  "
                + sparseTable.findMinElement(0, 8));
    }

    private int[][] table;

    public SparseTable(final int[] array) {

        if (array == null || array.length == 0) {
            throw new UnsupportedOperationException();
        }

        int tableLength = findTableLength(array.length);
        this.table = new int[array.length][tableLength];

        initFirstColumn(array);
        buildTable();
    }

    private int findTableLength(final int arrayLength) {

        int highestOneBit = Integer.highestOneBit(arrayLength);

        return (highestOneBit == arrayLength ?
                1 + indexOfOneBit(highestOneBit) :
                2 + indexOfOneBit(highestOneBit));
    }

    private int indexOfOneBit(final int highestOneBit) {

        int startIndex = 0, endIndex = 31;

        while (startIndex < endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            int currentResult = (1 << middleIndex);

            if (currentResult == highestOneBit) {
                return middleIndex;
            } else if (currentResult > highestOneBit) {
                endIndex = middleIndex;
            } else {
                startIndex = middleIndex;
            }
        }

        return -1;
    }

    private void initFirstColumn(final int[] array) {

        for (int i = 0; i < array.length; i++) {
            this.table[i][0] = array[i];
        }
    }

    private void buildTable() {

        for (int lengthIndexOfTwo = 1;
             lengthIndexOfTwo < table[0].length; lengthIndexOfTwo++) {

            for (int startIndex = 0;
                 startIndex + (1 << (lengthIndexOfTwo - 1)) < table.length;
                 startIndex++) {

                table[startIndex][lengthIndexOfTwo]
                        = Math.min(table[startIndex][lengthIndexOfTwo - 1],
                        table[startIndex + (1 << (lengthIndexOfTwo - 1))][lengthIndexOfTwo - 1]);
            }
        }
    }

    public void printTable() {

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (table[row][col] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(table[row][col]);
                }
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    /**
     * To find the minimum element within a range.
     *
     * @param startIndex the start index of the searching range (inclusive)
     * @param endIndex   the end index of the searching range (exclusive)
     * @return the minimum element with the range
     */
    public int findMinElement(int startIndex, int endIndex) {

        int rangeLength = endIndex - startIndex;
        int highestOneBit = Integer.highestOneBit(rangeLength);
        int indexOfHighestOneBit = indexOfOneBit(highestOneBit);

        if (highestOneBit == rangeLength) {
            return table[startIndex][indexOfHighestOneBit];
        } else {
            return Math.min(table[startIndex][indexOfHighestOneBit],
                    table[endIndex - highestOneBit][indexOfHighestOneBit]);
        }
    }
}