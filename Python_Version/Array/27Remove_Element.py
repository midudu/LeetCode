#Given an array and a value, remove all instances of that value in place and return the new length.

#Do not allocate extra space for another array, you must do this in place with constant memory.

#The order of elements can be changed. It doesn't matter what you leave beyond the new length.

#Example:
#Given input array nums = [3,2,2,3], val = 3

#Your function should return length = 2, with the first two elements of nums being 2.

class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        
        nums_length = len(nums) 
        if ( nums_length == 0):
            return nums_length
               
        slow = 0
        for fast in range(nums_length):
            if ( nums[fast] != val ):
                nums[slow] = nums[fast]
                slow += 1

        return slow


if __name__ == '__main__':
    nums = [3,3,5,6,7,8,2]
    sol = Solution()
    a = sol.removeElement(nums, 3)
    print a
    print nums
