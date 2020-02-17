/*
  Given an array nums of n integers and an integer target, are there elements
a, b, c, and d in nums such that a + b + c + d = target? Find all unique
quadruplets in the array which gives the sum of target.

Note:
  The solution set must not contain duplicate quadruplets.

Example:

  Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

  A solution set is:
[
[-1,  0, 0, 1],
[-2, -1, 1, 2],
[-2,  0, 0, 2]
]*/

#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int> &nums, int target) {

        ios_base::sync_with_stdio(false);
        cin.tie(nullptr);
        cout.tie(nullptr);

        vector<vector<int>> result;
        if (nums.size() < 4) {
            return result;
        }

        sort(nums.begin(), nums.end());

        if (nums[0] + nums[1] + nums[2] + nums[3] > target
            || nums[nums.size() - 1] + nums[nums.size() - 2]
               + nums[nums.size() - 3] + nums[nums.size() - 4] < target) {
            return result;
        }

        int newTarget, startIndex, endIndex, currentSum;
        for (int i = 0; i < (int) nums.size() - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[nums.size() - 1]
                + nums[nums.size() - 2] + nums[nums.size() - 3] < target) {
                continue;
            }

            for (int j = i + 1; j < (int) nums.size() - 2; j++) {
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[nums.size() - 1] + nums[nums.size() - 2] < target) {
                    continue;
                }

                newTarget = target - nums[i] - nums[j];
                startIndex = j + 1, endIndex = (int) nums.size() - 1;

                while (startIndex < endIndex) {
                    while (startIndex < endIndex &&
                           startIndex != j + 1 && nums[startIndex] == nums[startIndex - 1]) {
                        startIndex++;
                    }
                    while (startIndex < endIndex &&
                           endIndex != (int) nums.size() - 1 && nums[endIndex] == nums[endIndex + 1]) {
                        endIndex--;
                    }
                    if (startIndex < endIndex) {
                        currentSum = nums[startIndex] + nums[endIndex];
                        if (currentSum == newTarget) {
                            result.emplace_back(initializer_list<int>{
                                    nums[i], nums[j], nums[startIndex], nums[endIndex]});
                            startIndex++;
                            endIndex--;
                        } else if (currentSum < newTarget) {
                            startIndex++;
                        } else {
                            endIndex--;
                        }
                    }
                }
            }
        }

        return result;
    }
};

int main() {

    Solution solution;

    vector<int> nums = initializer_list<int>{1, 0, -1, 0, -2, 2};
    int target = 0;

    vector<vector<int>> result = solution.fourSum(nums, target);

    return 0;
}
