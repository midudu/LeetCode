/*
  There are two sorted arrays nums1 and nums2 of size m and n respectively.

  Find the median of the two sorted arrays. The overall run time complexity
should be O(log (m+n)).

  You may assume nums1 and nums2 cannot be both empty.

Example 1:

  nums1 = [1, 3]
  nums2 = [2]

  The median is 2.0

Example 2:

  nums1 = [1, 2]
  nums2 = [3, 4]

  The median is (2 + 3)/2 = 2.5
*/

#include <vector>
#include <cassert>

using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2) {
        int total = (int) nums1.size() + (int) nums2.size();
        int k = total / 2;
        if (total % 2 == 0) {
            int v1 = findKthElement(nums1, nums2, k);
            int v2 = findKthElement(nums1, nums2, k + 1);
            return (v1 + v2) / 2.0;
        } else {
            int v = findKthElement(nums1, nums2, k + 1);
            return v;
        }
    }
private:
    int findKthElement(vector<int> &nums1, vector<int> &nums2, int k) {
        int startIndex1 = 0, startIndex2 = 0;
        int lastIndex1, lastIndex2;
        int lastValue1, lastValue2;

        while (k) {
            if (startIndex1 >= nums1.size()) {
                return nums2[startIndex2 + k - 1];
            }
            if (startIndex2 >= nums2.size()) {
                return nums1[startIndex1 + k - 1];
            }

            if (k == 1) {
                return min(nums1[startIndex1], nums2[startIndex2]);
            }

            lastIndex1 = startIndex1 + k / 2 - 1;
            lastIndex2 = startIndex2 + k / 2 - 1;

            lastValue1 = lastIndex1 >= nums1.size() ? INT_MAX : nums1[lastIndex1];
            lastValue2 = lastIndex2 >= nums2.size() ? INT_MAX : nums2[lastIndex2];


            if (lastValue1 > lastValue2) {
                startIndex2 += k / 2;
            } else {
                startIndex1 += k / 2;
            }
            k -= k / 2;
        }

        assert(false);
    }
};

int main() {

    vector<int> nums1 = std::initializer_list<int>{1, 3, 5, 7, 9};
    vector<int> nums2 = std::initializer_list<int>{2, 4, 6, 8};

    Solution solution;

    double result = solution.findMedianSortedArrays(nums1, nums2);

    return 0;
}
