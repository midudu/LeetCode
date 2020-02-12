/*
  Given an array nums of n integers and an integer target, find three integers
in nums such that the sum is closest to target. Return the sum of the three
integers. You may assume that each input would have exactly one solution.

Example:
  Given array nums = [-1, 2, 1, -4], and target = 1.
  The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

#include <vector>
#include <cassert>
#include <algorithm>

using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int> &nums, int target) {

        assert(nums.size() > 2);
        sort(nums.begin(), nums.end());

        int startIndex, endIndex;
        int newTarget, currentSum, newAbsDiff;

        int minAbsDiff = INT_MAX;
        bool isDiffPositive = true;

        for (int i = 0; i < (int) nums.size() - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            startIndex = i + 1;
            endIndex = (int) nums.size() - 1;
            newTarget = target - nums[i];

            while (startIndex < endIndex) {
                while (startIndex < endIndex && startIndex != i + 1
                       && nums[startIndex] == nums[startIndex - 1]) {
                    startIndex++;
                }
                while (startIndex < endIndex && endIndex != (int) nums.size() - 1
                       && nums[endIndex] == nums[endIndex + 1]) {
                    endIndex--;
                }
                if (startIndex < endIndex) {
                    currentSum = nums[startIndex] + nums[endIndex];
                    if (currentSum == newTarget) {
                        return target;
                    } else if (currentSum < newTarget) {
                        newAbsDiff = newTarget - currentSum;
                        if (newAbsDiff < minAbsDiff) {
                            minAbsDiff = newAbsDiff;
                            isDiffPositive = false;
                        }
                        startIndex++;
                    } else /*if (currentSum > newTarget)*/{
                        newAbsDiff = currentSum - newTarget;
                        if (newAbsDiff < minAbsDiff) {
                            minAbsDiff = newAbsDiff;
                            isDiffPositive = true;
                        }
                        endIndex--;
                    }
                }
            }
        }

        return isDiffPositive ? target + minAbsDiff : target - minAbsDiff;
    }
};

int main() {

    Solution solution;

    vector<int> nums = initializer_list<int>{-1, 2, 1, -4};
    int target = 1;

    int result = solution.threeSumClosest(nums, target);

    return 0;
}
