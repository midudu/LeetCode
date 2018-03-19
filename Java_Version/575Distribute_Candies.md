/*Given an integer array with even length, where different numbers in this array represent different kinds of candies. Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister. Return the maximum number of kinds of candies the sister could gain.

 Example 1:

 Input: candies = [1,1,2,2,3,3]

 Output: 3

 Explanation:

 There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 
The sister has three different kinds of candies.
 
 Example 2:

 Input: candies = [1,1,2,3]

 Output: 2

 Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].

 The sister has two different kinds of candies, the brother has only one kind of candies.
 
  Note:

  The length of the given array is in range [2, 10,000], and will be even.
  The number in given array is in range [-100,000, 100,000].*/


 
* 
* 思想：

* (1) 这道题比较简单，主要是需要弄清题意，把 candies种类存进hashset中，选择 halfLength与hashset.size 中较小的一个输出 
*
* (2) 可以优化的地方在于，当 hashset.size已经超过halfLength时，就可以退出了

------

    public int distributeCandies(int[] candies) {

        int candiesLength = candies.length;
        int halfLength = candiesLength/2;

        HashSet<Integer> candiesType = new HashSet<>();

        int count = 0;
        for (int i = 0; i < candiesLength; i++) {
            if (candiesType.add(candies[i])){
                count++;
                if (count >= halfLength){
                    return halfLength;
                }
            }
        }

        return candiesType.size();
    }
