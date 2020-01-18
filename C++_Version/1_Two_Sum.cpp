/*
  Given an array of integers, return indices of the two numbers such that they
add up to a specific target.

  You may assume that each input would have exactly one solution, and you may
not use the same element twice.

Example:
  Given nums = [2, 7, 11, 15], target = 9,

  Because nums[0] + nums[1] = 2 + 7 = 9, return[0, 1].
*/

#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {

        vector<int> result = vector<int>(2);
        unordered_map<int, int> numIndexMap = unordered_map<int, int>(nums.size());

        for (vector<int>::size_type i = 0; i < nums.size(); i++) {
            int num = nums[i];
            auto it = numIndexMap.find(target - num);
            if (it != numIndexMap.end()) {
                result[0] = it->second;
                result[1] = i;
                break;
            } else {
                numIndexMap[num] = i;
            }
        }

        return result;
    }
};

int main(int argc, char **args) {

    vector<int> nums = {3, 2, 4};
    Solution solution = Solution();

    vector<int> result = solution.twoSum(nums, 6);

    return 0;
}
