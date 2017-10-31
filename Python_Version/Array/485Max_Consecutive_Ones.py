#Given a binary array, find the maximum number of consecutive 1s in this array.

#Example 1:
#Input: [1,1,0,1,1,1]
#Output: 3
#Explanation: The first two digits or the last three digits are consecutive 1s.
#    The maximum number of consecutive 1s is 3.
#Note:

#The input array will only contain 0 and 1.
#The length of input array is a positive integer and will not exceed 10,000

class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_consecutive_ones = 0
        consecutive_ones = 0
        One_flag = False

        for num in nums:
            if (num == 1):
                One_flag = True
                consecutive_ones += 1
            if (num == 0 and One_flag == True):
                One_flag = False
                if ( consecutive_ones > max_consecutive_ones ):
                    max_consecutive_ones = consecutive_ones
                consecutive_ones = 0;

        if (One_flag == True and consecutive_ones > max_consecutive_ones):
            max_consecutive_ones = consecutive_ones

        return max_consecutive_ones


if __name__ == '__main__':
    nums = [1,1,0,1,1,1]
    sol = Solution()
    a = sol.findMaxConsecutiveOnes(nums)
    print a
