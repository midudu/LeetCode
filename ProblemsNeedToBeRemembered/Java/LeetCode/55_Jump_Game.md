* [原文地址](https://leetcode.com/articles/jump-game/ "https://leetcode.com/articles/jump-game/")

* 题目：LeetCode_55_Jump Game 
 
        Given an array of non-negative integers, you are initially positioned at the first index of the array.

        Each element in the array represents your maximum jump length at that position.

        Determine if you are able to reach the last index.

        Example 1:

        Input: [2,3,1,1,4]
        Output: true
        Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

        Example 2:

        Input: [3,2,1,0,4]
        Output: false
        Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

    题目的意思是：现在给定一个数组，数组的每一项一个格子，每一项的数值代表从当前格子最远可以向后跳多少个格子。现在问题是：假设你站在第一个格子上，根据给定的数组，你是否有办法跳到最后一个格子？

* 这个问题刚开始看到时肯定有思路，这个思路一般来说是__回溯法__的思路；如果题目刷的多一些，就会发现回溯法一般存在的问题是无法利用已知信息，所以正确答案的思路往往是__动态规划__，那如何由回溯法转到动态规划呢？总共分__4步__

    (1) 先想一个能用回溯法解决的算法

    (2) 用一个用来存储的表(memoization table)，记录已经计算过的部分的结果，这样可以部分优化(1)的算法，但是依然还是__从顶向下__递归地解决问题

    (3) 想办法不用递归解决问题，这时就变成了__从底向上__动态规划地解决问题

    (4) 进行最后的时间复杂度/空间复杂度优化

* 为了进行下面的说明，先定义一下什么叫“好的位置”(good index)，什么叫“坏的位置”(bad index)。好的位置指的就是如果人站在当前位置，他有办法跳到最后一个格子；坏的位置就是如果人站在当前位置，他没办法跳到最后一个格子。所以，这个问题变成了：__判断0是不是一个好的位置__

    接下来看看__四步法__是怎么在这个问题中运用的

* __第一步__：暴力递归回溯

    直接按照最简单的想法做，应该会写出下面一样的代码

        public class Solution {

            public boolean canJump(int[] nums) {
                return canJumpFromPosition(0, nums);
            }

            public boolean canJumpFromPosition(int position, int[] nums) {

                if (position == nums.length - 1) {
                    return true;
                }

                int furthestJump = Math.min(position + nums[position], nums.length - 1);

                for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                    if (canJumpFromPosition(nextPosition, nums)) {
                        return true;
                    }
                }

                return false;
            }
        }

    虽然这种方法肯定不是优的方法，但是对这种方法还是可以做出一个小的优化：那就是每次找的时候从furthestJump往回找，这样有更大概率先碰到答案从而返回，小优化之后是这样的：

        public class Solution {

            public boolean canJump(int[] nums) {
                return canJumpFromPosition(0, nums);
            }

            public boolean canJumpFromPosition(int position, int[] nums) {

                if (position == nums.length - 1) {
                    return true;
                }

                int furthestJump = Math.min(position + nums[position], nums.length - 1);

                for (int nextPosition = furthestJump; nextPosition > position; nextPosition--) {
                    if (canJumpFromPosition(nextPosition, nums)) {
                        return true;
                    }
                }

                return false;
            }
        }

    这样做最大的时间复杂度是O(2^n)，空间复杂度是O(n)，因为递归每次要压栈帧

* __第二步__：用表的方式存储每步的结果

    第一步中的算法不好的一个重要原因是：明明有的位置已经判断过它是不是好的位置了，但是后续的判断中却无法利用已知的结果。所以可以考虑用表来记录已知的结果，代码如下：

        public class Solution {

            enum Index {
                GOOD, BAD, UNKNOWN
            }

            Index[] memo;

            public boolean canJump(int[] nums) {

                memo = new Index[nums.length];

                for (int i = 0; i < memo.length; i++) {
                    memo[i] = Index.UNKNOWN;
                }

                memo[memo.length - 1] = Index.GOOD;

                return canJumpFromPosition(0, nums);
           }

            public boolean canJumpFromPosition(int position, int[] nums) {

                if (memo[position] != Index.UNKNOWN) {
                    return memo[position] == Index.GOOD ? true : false;
                }

                int furthestJump = Math.min(position + nums[position], nums.length - 1);

                for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {

                    if (canJumpFromPosition(nextPosition, nums)) {
                        memo[position] = Index.GOOD;
                        return true;
                    }
                }

                memo[position] = Index.BAD;
                return false;
            }
        }

    相比第一步的方法，这种方法每次都会保存已知的结果，大大减少了计算量

    时间复杂度：O(n^2)

    空间复杂度：O(2n) = O(n) （2n的原因是一个n代表递归栈帧，一个n代表存储表空间）

* __第三步__：由从顶向下改为从底向下

    第二步存在的问题是总是需要递归调用，虽然说可以靠查表的方式弥补问题，但是也总是需要要压栈、出栈的递归调用过程。如果像搭积木一样从底层慢慢向上搭，那效率又会提升。

    对于这个问题，最底层的积木是我们已知最后一个格子一定是一个好格子，我们可以从后向前一路“蔓延”过去，这样到判断第0个格子的时候，积木已经完全搭好。        

        public class Solution {

            enum Index {
                GOOD, BAD, UNKNOWN
            }

            public boolean canJump(int[] nums) {

                Index[] memo = new Index[nums.length];

                for (int i = 0; i < memo.length; i++) {
                    memo[i] = Index.UNKNOWN;
                }

                memo[memo.length - 1] = Index.GOOD;

                for (int i = nums.length - 2; i >= 0; i--) {

                    int furthestJump = Math.min(i + nums[i], nums.length - 1);

                    for (int j = i + 1; j <= furthestJump; j++) {
                        if (memo[j] == Index.GOOD) {
                            memo[i] = Index.GOOD;
                            break;
                        }
                    }
                }

                return memo[0] == Index.GOOD;
            }
        }

    时间复杂度：O(n^2)

    空间复杂度：O(n)

    虽然时间复杂度上没变（其实具体执行时间是变小了的，因为没有递归调用的过程），但是空间复杂度变成了一半（helper函数不见了，因为不需要递归调用）。更重要的是它为第四步提供了思路

* __第四步__：最后的优化

        public class Solution {

            public boolean canJump(int[] nums) {

                int lastPos = nums.length - 1;

                for (int i = nums.length - 1; i >= 0; i--) {
                    if (i + nums[i] >= lastPos) {
                        lastPos = i;
                    }
                }

                return lastPos == 0;
            }
        }

    从第三步的结果中，我们可以观察到另一个问题：每次我们判断当前格子是不是好的位置时，只需要判断从当前位置能到达的最远的位置是否大于等于已知的好的位置。初始时已知的最好的位置是最后一个格子，那么随着从右向左遍历数组的过程，我们对每个格子都可以判断出它是不是一个好的位置，如果是的话，那么当前最左边的好的位置就是当前格子，这样只需要一个变量保存结果即可——最左边的好的位置。

        public class Solution {

            public boolean canJump(int[] nums) {

                int lastPos = nums.length - 1;

                for (int i = nums.length - 1; i >= 0; i--) {

                    if (i + nums[i] >= lastPos) {
                        lastPos = i;
                    }
                }

                return lastPos == 0;
            }
         }

    时间复杂度：O(n)（只需要遍历一次数组）

    空间复杂度：O(1)（只需要一个额外变量）


* __结论__

    (1) 最终的代码一定是优雅的，但是这是经过几个步骤最后得来的

    (2) 对于面试中碰到这类问题，不要卡很长时间去思考最优的办法，而是先告诉面试官那个最简单直观的回溯法解决问题的思路（第一步解法），然后看看这个是不是面试官想要的解法：如果是，这个题就结束了；如果不是，想一想用存储表的方式进行改进（第二步解法）。能到这一步往往就已经是不错的结果了。最后的话，可以考虑和面试官交流一下自底向上的方法（第三步），作为你独到的思考。第四步往往是可遇不可求的。

The (recursive) backtracking is the easiest to figure out, so it is worth mentioning it verbally while warming up for the tougher challenge. It might be that your interviewer actually wants to see that solution, but if not, mention that there might be a dynamic programming solution and try to think how could you use a memoization table. If you figure it out and the interviewer wants you to go for the top-down approach, it will not generally be time to think of the bottom-up version, but I would always mention the advantages of this technique as a final thought in the interview.

Most people are stuck when converting from top-down Dynamic Programming (expressed naturally in recursion) to bottom-up. Practicing similar problems will help bridge this gap.