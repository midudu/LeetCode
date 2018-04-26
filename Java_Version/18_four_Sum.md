/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

  Note: The solution set must not contain duplicate quadruplets.

  For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

  A solution set is:
  
      [
        [-1,  0, 0, 1],
        [-2, -1, 1, 2],
        [-2,  0, 0, 2]
        ]*/


 
* 
* 思想：

* (1) 这道题的整体思路和15题很像，也是通过双指针的方式降低复杂度（由O(n^4)降到O(n^3))。首先也要对数组进行排序。

* (2) 为了防止输出重复结果，对于3个变量都要跳过重复元素；

* (3) 为了提高效率，需要尽可能地进行情况剪枝。值得注意的是每次进循环前都要剪枝，决定是continue还是break

----
    
    class Solution {
    //o(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-3;i++){
            
            if (nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)
                break;
            if (nums[i]+nums[n-1]+nums[n-2]+nums[n-3]<target)
                continue;
            if (i>0 && nums[i]==nums[i-1]) 
                continue;
            
            for(int j=i+1;j<n-2;j++) {
                
                if (nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) 
                    break;
                if (nums[i]+nums[j]+nums[n-2]+nums[n-1]<target) 
                    continue;
                if(j>i+1 && nums[j]==nums[j-1]) 
                    continue;
                int low = j+1, high = n-1;
                
                while(low<high){
                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                  
                        while(low<high && nums[low]==nums[low+1])
                            low++;
                        while(low<high && nums[high]==nums[high-1])
                            high--;
                        low++;
                        high--;
                    }
                    else if(sum<target) 
                        low++;
                    else 
                        high--;
                }
            }
        }
        return res;
        
    }
}