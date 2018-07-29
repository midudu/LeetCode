package unionFindSet;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is to build a union-find-set object. There are two basic
 * functions for a union-find-set object: union and find.
 *
 * "find" operation is to find the index of the root node of the current node.
 * To make the union-find-set "short and fat", every node in the find path are
 * merged to the root node during the "find" operation.
 *
 * "union" operation is to make the two nodes have the same root. A smaller
 * tree will be merged to a larger tree when unioned.
 *
 *
 */
public class UnionFindSet {

    /**
     * An array to store the root index of the current node. For the root node,
     * the value is { 0 - the size of tree}
     */
    private int[] rootIndexTable;

    /**
     * Constructor
     *
     * @param size the size of the union find set
     */
    public UnionFindSet(int size) {

        assert (size > 0);

        rootIndexTable = new int[size];

        for (int i = 0; i < rootIndexTable.length; i++) {
            rootIndexTable[i] = -1;
        }
    }

    /**
     * To union two nodes.
     *
     * @param index1 the index of the first node
     * @param index2 the index of the second node
     */
    public void union(int index1, int index2) {

        assert (index1 >= 0 && index1 < this.rootIndexTable.length);
        assert (index2 >= 0 && index2 < this.rootIndexTable.length);

        int rootIndex1 = find(index1);
        int rootIndex2 = find(index2);

        if (rootIndex1 == rootIndex2) {
            return;
        }

        int size1 = -this.rootIndexTable[rootIndex1];
        int size2 = -this.rootIndexTable[rootIndex2];

        if (size1 < size2) {
            this.rootIndexTable[rootIndex1] = rootIndex2;
            this.rootIndexTable[rootIndex2] = -size1 - size2;
        } else {
            this.rootIndexTable[rootIndex2] = rootIndex1;
            this.rootIndexTable[rootIndex1] = -size1 - size2;
        }
    }

    /**
     * To find the root index of the current node.
     *
     * @param index the index of the current node
     * @return the root index of the current node
     */
    public int find(int index) {

        if (this.rootIndexTable[index] < 0) {
            return index;
        } else {
            int rootIndex = find(rootIndexTable[index]);
            this.rootIndexTable[index] = rootIndex;
            return rootIndex;
        }
    }
}


class TestUnionFindSet {

    public static void main(String[] args) {

        UnionFindSet unionFindSet = new UnionFindSet(15);

        unionFindSet.union(0, 1);
        unionFindSet.union(0, 2);
        unionFindSet.union(0, 3);

        unionFindSet.union(4, 5);

        unionFindSet.union(6, 7);
        unionFindSet.union(6, 8);

        unionFindSet.union(9, 10);
        unionFindSet.union(9, 11);
        unionFindSet.union(9, 12);

        unionFindSet.union(12, 13);
        unionFindSet.union(12, 14);

        System.out.println();
    }
}