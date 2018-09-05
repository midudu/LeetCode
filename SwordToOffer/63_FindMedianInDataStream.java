/* 
题目描述
如何得到一个数据流中的中位数？

如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。 */

import java.util.TreeSet;
import java.util.Iterator;

public class Solution {

    private TreeSet<Integer> numSet = new TreeSet<Integer>();
	

    public void Insert(Integer num) {
    
	    numSet.add(num);
    }

    public Double GetMedian() {
        
		int size = numSet.size();
		if ( size % 2 == 1 ) {
			int k = size / 2;
			
			Iterator<Integer> iterator = numSet.iterator();
			int count = -1;
			while ( iterator.hasNext() ) {
				
				int currentValue = iterator.next();
				count++;
				if ( count == k ) {
					return Double.valueOf((double)currentValue);
				}
			}
			
		} else {
			int firstNumber = 0;
			int k1 = size / 2 - 1;
			int k2 = size / 2;
			
			Iterator<Integer> iterator = numSet.iterator();
			int count = -1;
			while ( iterator.hasNext() ) {
				
				int currentValue = iterator.next();
				count++;
				if ( count == k1 ) {
					firstNumber = currentValue;
				}
				if ( count == k2 ) {
					return Double.valueOf( (firstNumber + currentValue)/2.0 );
				}
			}
		}
		
		return 0.0;
    }
}