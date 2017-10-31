#Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

#Do not allocate extra space for another array, you must do this in place with constant memory.

#For example,
#Given input array nums = [1,1,2],

#Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.

class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums_size = len(nums)
        if ( nums_size == 0 or nums_size == 1 ):
            return nums_size

        slow = 0
        for fast in range(1,nums_size):
            if ( nums[fast] != nums[slow] ):
                slow += 1
                nums[slow] = nums[fast]

        #for i in range(duplicate_count):
        #    nums.pop()

        return (slow + 1)


if __name__ == '__main__':
    nums = [1,1,2,2,3,4,4,5,6]
    sol = Solution()
    a = sol.removeDuplicates(nums)
    print a
    print nums
