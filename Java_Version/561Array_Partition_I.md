/*Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
 Input: [1,4,3,2]

 Output: 4

 Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).

 Note:

 n is a positive integer, which is in the range of [1, 10000].
  All the integers in the array will be in the range of [-10000, 10000].


 
* 
* 思想：

* (1) 基本的思路是先排序然后把偶数序数的元素相加，这样的复杂度是 O(nlogn + n) = O(nlogn)
*
* (2) 这道题的特殊之处在于给定了输入元素的范围是 (-10000，+10000)，这样可以建立一个 int[20001]的数组作为哈希表。具体操作是遍历数组，把所有元素加10000后出现的次数存进哈希表；然后读这个哈希表，跳过为0的部分（这说明该元素减-10000对应的数没有出现过），对于非零的部分，隔一次相加得到结果，这样做的复杂度为 O(n)
* 
* (3) 这道题值得借鉴的地方是 哈希表思想，而且很多时候可以用数组代表各种数据结构。但是这道题的特殊之处在于给定了输入数据的范围，如果没有给定输入数据的范围，需要用 TreeMap<Integer, Integer>，这样做依然是 O(nlogn)，就没有必要这样做了

------

    public int arrayPairSum(int[] nums) {

        int[] hashTable = new int[20001];

        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            hashTable[nums[i] + 10000]++;
        }

        int result = 0, count = 0;
        int parityFlag = 1;
        for (int i = 0; i < 20001; ) {

            if (hashTable[i] > 0) {

                hashTable[i] --;
                if (parityFlag == 1) {
                    result += (i - 10000);
                }
                parityFlag = 1- parityFlag;
            } else {
                i++;
            }
        }

        return result;
    }

