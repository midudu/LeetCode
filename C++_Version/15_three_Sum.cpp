/*
  Given an array nums of n integers, are there elements a, b, c in nums such
that a + b + c = 0? Find all unique triplets in the array which gives the sum
of zero.

Note:
  The solution set must not contain duplicate triplets.

Example:

  Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
[-1, 0, 1],
[-1, -1, 2]
]
*/

#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int> &nums) {
        vector<vector<int>> result;

        if (nums.empty()) {
            return result;
        }

        sort(nums.begin(), nums.end());
        int startPointer, endPointer, target;

        for (int i = 0; i < (int) nums.size() - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (nums[i] + nums[nums.size() - 2] + nums[nums.size() - 1] < 0) {
                continue;
            }

            startPointer = i + 1;
            endPointer = (int) nums.size() - 1;
            target = -nums[i];

            while (startPointer < endPointer) {
                while (startPointer < endPointer && startPointer != i + 1
                       && nums[startPointer] == nums[startPointer - 1]) {
                    startPointer++;
                }
                while (startPointer < endPointer && endPointer != (int) nums.size() - 1
                       && nums[endPointer] == nums[endPointer + 1]) {
                    endPointer--;
                }

                if (startPointer < endPointer) {
                    if (nums[startPointer] + nums[endPointer] < target) {
                        startPointer++;
                    } else if (nums[startPointer] + nums[endPointer] > target) {
                        endPointer--;
                    } else {
                        result.emplace_back(initializer_list<int>{
                                nums[i], nums[startPointer], nums[endPointer]});
                        startPointer++;
                        endPointer--;
                    }
                }
            }
        }

        return result;
    }
};


int main() {

    Solution solution;

    vector<int> input = {-1, 0, 1, 2, -1, -4};
    vector<vector<int>> result = solution.threeSum(input);

    return 0;
}
