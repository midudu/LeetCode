/*Author: Bochen (mddboc@foxmail.com)
Last Modified: Tue Apr 10 22:28:44 CST 2018*/

/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

  Note: You may not slant the container and n is at least 2.*/

 
* 
* 思想：

* (1) 这道题首先要注意审题，容器不是密封的，所以 容器能装的水的体积应该用矩形面积公式来算

* (2) 这道题的思路很巧妙，大的思想还是双指针思想，一个指向头，一个指向尾，笨方法遍历是O(n^2)，减小复杂度的方法是

----    
        while (startPointer < endPointer) {

            startPointerHeight = height[startPointer];
            endPointerHeight = height[endPointer];

            maxAreaValue = Math.max(maxAreaValue,
                    (endPointer - startPointer) * Math.min(startPointerHeight, endPointerHeight));

            if ( startPointerHeight <= endPointerHeight ){
                startPointer++;
            }else{
                endPointer--;
            }
        }

这样做的道理是如果左边挡板高度小于等于右边挡板高度，那么如果保持左边挡板不动，无论怎样向左移动右边挡板，形成的容器的装水量总是小于等于当前装水量，所以正确答案应该在移动左边挡板的情况中寻找；同理可说明 左边挡板高度大于右边的情况