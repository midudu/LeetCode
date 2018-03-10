/*Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/


 
* 
* 思想：

* (1) 这道题的整体思路和15题很像，也是通过双指针的方式降低复杂度。首先也要对数组进行排序。

* (2) 为了防止输出重复结果，对于3个变量都要跳过重复元素；

* (3) 为了提高效率，需要尽可能地进行情况剪枝。首先在进入循环之前，计算最小值和最大值，如果最小值大于target或最大值小于target，那么直接就可以输出结果了；

* (4) 为了减小比较的次数，设置了两个最接近target的值，一个是小于target的目标值loCount，一个是大于target的目标值hiCount，不需要每次进行绝对值比较，只需要最后比较一次

----
    
    for (int head = 0; head < nums.length - 2; head++) {

        //lo and hi denotes smallest and biggest values of current head iteration
        int lo = nums[head] + nums[head + 1] + nums[head + 2],
            hi = nums[head] + nums[len - 2] + nums[len - 1];

        if (lo > target) {//if lo is too big, update your hiCount and terminate loop
            if (hiCount > lo) //
                hiCount = lo;

            break;
        
        } else if (hi < target) { //if hi is too small, update your loCount and skip current iteration

            if (loCount < hi)
                loCount = hi;

            continue;
        }

        //low and high denotes your array index pointers
        int low = head + 1, high = len - 1;
        while (low < high) {
            int sum = nums[low] + nums[high] + nums[head];
        
            if (sum == target) {
                return target;
            } else if (sum < target) {
                if (loCount < sum)
                    loCount = sum;
                while (++low < len - 1 && nums[low] == nums[low - 1]);
            
            } else {
                if (hiCount > sum)
                    hiCount = sum;
                while (--high > head + 1 && nums[high] == nums[high + 1]) ;
            }
        }
    }
    return (hiCount - target) > (target - loCount) ? loCount : hiCount;