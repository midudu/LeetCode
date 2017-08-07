#Given an array of integers, return indices of the two numbers such that they add up to a specific target.

#You may assume that each input would have exactly one solution, and you may not use the same element twice.

#Example:
#Given nums = [2, 7, 11, 15], target = 9,

#Because nums[0] + nums[1] = 2 + 7 = 9,
#return [0, 1].


class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dictionary = { }
        output = [ ]
        index = 0

        for num in nums:
            remain_num = target - num

            if remain_num in dictionary:
                output.append(dictionary[remain_num])
                output.append(index)
                return output
            else:
                dictionary[num] = index
                
            index = index + 1

        return output



sol1 = Solution()
nums = [2, 7, 11, 15]
target = 9
receive = sol1.twoSum(nums, target)

a = 1