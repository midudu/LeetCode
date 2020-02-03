/*
  Given n non-negative integers a1, a2, ..., an , where each represents a point
at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

  Input: [1,8,6,2,5,4,8,3,7]
  Output: 49
*/

#include <vector>
#include <cassert>
#include <algorithm>
#include <cstdio>

using namespace std;

class Solution {
public:
    int maxArea(vector<int> &height) {
        assert(height.size() > 1);

        int result = 0;
        int leftPointer = 0, rightPointer = height.size() - 1;

        int leftHeight = -1, rightHeight = -1;

        while (leftPointer < rightPointer) {
            leftHeight = height[leftPointer];
            rightHeight = height[rightPointer];

            int currentArea = (rightPointer - leftPointer) * min(leftHeight, rightHeight);
            result = max(result, currentArea);

            if (leftHeight <= rightHeight) {
                while (leftPointer < rightPointer
                       && height[leftPointer] <= leftHeight)
                    leftPointer++;
            } else {
                while (leftPointer < rightPointer
                       && height[rightPointer] <= rightHeight)
                    rightPointer--;
            }
        }

        return result;
    }
};

int main(int argc, char *args[]) {

    typedef vector<int> HeightList;
    HeightList height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

    int result = Solution().maxArea(height);
    printf("%d", result);

    return 0;
}
